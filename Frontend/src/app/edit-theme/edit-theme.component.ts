import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookeventService } from '../bookevent.service';
import { LoginService } from '../login.service';
import { FormBuilder ,FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-edit-theme',
  templateUrl: './edit-theme.component.html',
  styleUrls: ['./edit-theme.component.css']
})
export class EditThemeComponent implements OnInit {
  currentdate:any =new Date();
  constructor(private _loginService: LoginService, private _bookEvent: BookeventService, private route: ActivatedRoute, private router: Router,private formBuilder: FormBuilder) { }

  bookevent: any;
  eventId: any;
  editEvent : any;

  ngOnInit(): void {
    this.newForm();

    const routeParams = this.route.snapshot.paramMap;
    this.eventId = Number(routeParams.get('eventId'));

    console.log(this.eventId);
    this._bookEvent.getByEventId(this.eventId).subscribe((data) => {

      this.bookevent = data;
      this.forms();
    });



  }
  newForm()
  {
    this.editEvent = this.formBuilder.group({
      eventName:[{value:'',disabled:true},[Validators.required]],
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
      eventid:[''],
      themePrice:[0],
      addOnPrice:[0]
    })
  }
  forms() {
    this.editEvent = this.formBuilder.group({
      eventName:[this.bookevent.eventName,[Validators.required]],
      applicantName:[this.bookevent.applicantName,[Validators.required]],
      applicantAddress:[this.bookevent.applicantAddress,[Validators.required]],
      eventAddress:[this.bookevent.eventAddress,[Validators.required]],
      eventDate:[this.bookevent.eventDate,[Validators.required]],
      eventTime:[this.bookevent.eventTime,[Validators.required]],
      noOfPeople:[this.bookevent.noOfPeople,[Validators.required]],
      quantityOfVeg:[this.bookevent.quantityOfVeg,[Validators.required]],
      quantityOfNonVeg:[this.bookevent.quantityOfNonVeg,[Validators.required]],
     // selectFoodCategory:[this.bookevent.selectFoodCategory,[Validators.required]],
      applicantMobileNo:[this.bookevent.applicantMobileNo,[Validators.required,Validators.pattern("[0-9]{10}")]],
      applicantEmailId:[this.bookevent.applicantEmailId,[Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]],
      userId:[this._loginService.User.id],
      eventid:[this.bookevent.eventid],
      themePrice:[0],
      addOnPrice:[0]
    })
  }

  UpdateEvent() {
    this.editEvent.value.userId= this._loginService.User.id;
    this.editEvent.value.eventid= this.bookevent.eventid;
    this.editEvent.value.eventName=this.bookevent.eventName;
    this.editEvent.value.themePrice= this.bookevent.themePrice;
    this.editEvent.value.addOnPrice=this.bookevent.addOnPrice;
   
    this._bookEvent.updateEvent(this.editEvent.value, this.eventId).subscribe((data) => {

      alert("Successfully Updated");
      this.router.navigate(['viewbooking']);

    });

  }
}
