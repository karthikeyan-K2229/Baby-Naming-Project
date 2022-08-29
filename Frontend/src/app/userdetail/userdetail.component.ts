import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-userdetail',
  templateUrl: './userdetail.component.html',
  styleUrls: ['./userdetail.component.css']
})
export class UserdetailComponent implements OnInit {
  user:any
  
  constructor(private _loginService:LoginService,private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getUser(this._loginService.User.id).subscribe(data =>{
     this.user=data;
    
      console.log(data);
      console.log(this.user)
    })
  }

}
