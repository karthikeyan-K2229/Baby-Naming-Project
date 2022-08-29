import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AddmenuService } from '../addmenu.service';
import { Addtheme } from '../addtheme';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-updatetheme',
  templateUrl: './updatetheme.component.html',
  styleUrls: ['./updatetheme.component.css']
})
export class UpdatethemeComponent implements OnInit {
  themeid!: number;
  user: Addtheme = new Addtheme();
  updatetheme: any;
  constructor(  private _loginService : LoginService, private route: ActivatedRoute,private addthemeservice:AddmenuService,private  router : Router,private formBuilder: FormBuilder) { this.forms()}

  ngOnInit(): void {
    this.themeid = this.route.snapshot.params['themeid'];

    this.addthemeservice.getUserById(this.themeid).subscribe(data => {
      this.user = data;
      this.newforms();
    }, error => console.log(error));
  }

  newforms()
  {
    this.updatetheme = this.formBuilder.group({
      themeName:[this.user.themeName,[Validators.required,Validators.pattern("^[a-zA-Z' ']*")]],
    imageUrl:[this.user.imageUrl,[Validators.required]],
    photographerDetails:[this.user.photographerDetails,[Validators.required,Validators.pattern("^[a-zA-Z0-9,:;/.&' ']*")]],
    videographerDetails:[this.user.videographerDetails,[Validators.required,Validators.pattern("^[a-zA-Z0-9,;:/.&' ']*")]],
    returnGift:[this.user.returnGift,[Validators.required,Validators.pattern("^[a-zA-Z' '0-9]*")]],
    themeCost:[this.user.themeCost,[Validators.required,Validators.pattern("^[0-9]*")]],
    themeDiscription:[this.user.themeDiscription,[Validators.required,Validators.pattern("^[a-zA-Z0-9' ']*")]]
      
    })
  }
forms()
{
  this.updatetheme = this.formBuilder.group({
    themeName:['',[Validators.required,Validators.pattern("^[a-zA-Z' ']*")]],
    imageUrl:['',[Validators.required]],
    photographerDetails:['',[Validators.required,Validators.pattern("^[a-zA-Z0-9,:;/.&' ']*")]],
    videographerDetails:['',[Validators.required,Validators.pattern("^[a-zA-Z0-9,;:/.&' ']*")]],
    returnGift:['',[Validators.required,Validators.pattern("^[a-zA-Z' '0-9]*")]],
    themeCost:['',[Validators.required,Validators.pattern("^[0-9]*")]],
    themeDiscription:['',[Validators.required,Validators.pattern("^[a-zA-Z0-9' ']*")]]
  })
}

  update(){
    this.addthemeservice.updateUser(this.themeid, this.updatetheme.value).subscribe( data =>{
      this.goToUserList();
    },error=>alert("something went wrong "))
   
  }
  goToUserList(){
    alert("updated successfully");
    this.router.navigate(['/viewtheme']);
  }
  logout()
    {
      this._loginService.Logout();
    }
}
