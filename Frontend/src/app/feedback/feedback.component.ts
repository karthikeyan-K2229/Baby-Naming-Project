import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Feedback } from '../feedback';
import { LoginService } from '../login.service';
import { UserService } from '../user.service';
@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {
  
  successMessage:string;
  errorMessage:string;
  Addsfood: any;
 
  constructor(private router:Router,private _loginService : LoginService ,private userService:UserService,private formBuilder: FormBuilder,) { }
  
  ngOnInit(): void {
    this.forms();
  }
  AddTheme()
  {
    console.log(this.Addsfood.value);
    this.userService.sentFeedBack(this.Addsfood.value).subscribe(data=>{
      alert("Feedback Added Successfully")
      this.Addsfood.reset();    
  },error=>alert("Something went wrong"));
    }


  forms()
  {
    this.Addsfood = this.formBuilder.group({
      name:['',[Validators.required,Validators.pattern("^[a-zA-Z-]*")]],
      rating:['',[Validators.required]],
      feedback:['']
      
    })
  }
  
  logout()
  {
    this._loginService.Logout();
  }
}
