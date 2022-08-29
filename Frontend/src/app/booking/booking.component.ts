import { Component, OnInit } from '@angular/core';
//import { FormBuilder, Validators } from '@angular/forms';
import { FormBuilder ,FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
//import * as $ from 'jquery';
import { Observable } from 'rxjs';
import { AddOn } from '../add-on';
import { AddOnService } from '../add-on.service';
import { Bookevent } from '../bookevent';
import { BookeventService } from '../bookevent.service';
import { LoginService } from '../login.service'

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {
 
  currentdate:any =new Date();
  bookevent:Bookevent=new Bookevent();

  Booksevent: any;
  //adminAddOnService: any;
  ad1: Array<AddOn>=new Array();
  ad:AddOn=new AddOn();
  addOntoUpdate:AddOn=new AddOn();
  addV:Array<AddOn>=new Array();
  public form: any;
  //formBuilder: any;
  themeId:any;
  theme:any;
  totalPrice:number=0;
  private _router : Router;
  
  constructor(private bookeventService : BookeventService,private _loginService : LoginService ,private route: ActivatedRoute, private router: Router,
    private formBuilder: FormBuilder, private adminAddOnService:AddOnService) { }

  ngOnInit(): void {

    const routeParams = this.route.snapshot.paramMap;
    this.themeId = Number(routeParams.get('themeid'));

    this.adminAddOnService.GetTheme(this.themeId).subscribe(data => {
      this.theme= data;
      
      console.log(data);
      this.forms2();
    });


   /* $(".bookevent2").hide();

   $(".nextpage").click(function(){
     $(".bookevent2").show();
      $(".bookevent1").hide();
    });*/
    this.forms();
    this.getEmployees();
  }
  
  forms() {
    this.Booksevent = this.formBuilder.group({
      eventName:[{value:'',disabled:true},[Validators.required]],
      applicantName:['',[Validators.required]],
      applicantAddress:['',[Validators.required]],
      eventAddress:['',[Validators.required]],
      eventDate:['',[Validators.required]],
      eventTime:['',[Validators.required]],
      noOfPeople:['',[Validators.required]],
      quantityOfVeg:['',[Validators.required]],
      quantityOfNonVeg:['',[Validators.required]],
     // selectFoodCategory:['',[Validators.required]],
      applicantMobileNo:['',[Validators.required,Validators.pattern("[0-9]{10}")]],
      applicantEmailId:['',[Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]],
      userId:[this._loginService.User.id],
      themePrice:[0],
      addOnPrice:[0]
    })
  }
  forms2() {
    this.Booksevent = this.formBuilder.group({
      eventName:[{value:this.theme.themeName,disabled:true},[Validators.required]],
      applicantName:['',[Validators.required]],
      applicantAddress:['',[Validators.required]],
      eventAddress:['',[Validators.required]],
      eventDate:['',[Validators.required]],
      eventTime:['',[Validators.required]],
      noOfPeople:['',[Validators.required]],
      quantityOfVeg:['',[Validators.required]],
      quantityOfNonVeg:['',[Validators.required]],
      //selectFoodCategory:['',[Validators.required]],
      applicantMobileNo:['',[Validators.required,Validators.pattern("[0-9]{10}")]],
      applicantEmailId:['',[Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]],
      userId:[this._loginService.User.id],
      themePrice:[0],
      addOnPrice:[0]
    })
  }
  
      private getEmployees(){
        this.adminAddOnService.getEmployeesList().subscribe(data => {
          this.ad1 = data;
          console.log(data);
        });
      }

      UpdateTotalPrice(price,event)
      {
          if(event.target.checked)
          {
              this.totalPrice=this.totalPrice+Number(price);
          }
          else
          {
            this.totalPrice=this.totalPrice-Number(price);
          }
      }
    
      
  BookEvent(){
    console.log(this.Booksevent.value);
    this.Booksevent.value.userId= this._loginService.User.id;
    this.Booksevent.value.themePrice= Number(this.theme.themeCost);
    this.Booksevent.value.addOnPrice= this.totalPrice;
    this.Booksevent.value.eventName= this.theme.themeName;
    this.bookeventService. BookingEvent(this.Booksevent.value).subscribe(data=>{
      alert("Event Booked Successfully")
      this.router.navigate(['viewbooking']);
     },
    
     error=>alert("Something went wrong "));
    }

    logout()
    {
      this._loginService.Logout();
    }
}

