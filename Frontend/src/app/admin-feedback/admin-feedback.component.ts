import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-admin-feedback',
  templateUrl: './admin-feedback.component.html',
  styleUrls: ['./admin-feedback.component.css']
})
export class AdminFeedbackComponent implements OnInit {
  feedback:any;
  constructor(private userService:UserService,private _loginService : LoginService,) { }

  ngOnInit(): void {
    this.getFeedback();

  }
  getFeedback(){
    this.userService.getFeedback().subscribe(
      (data)=>{
        this.feedback=data;
        console.log(this.feedback);
      }
    )
  }
  logout()
  {
    this._loginService.Logout();
  }
}
