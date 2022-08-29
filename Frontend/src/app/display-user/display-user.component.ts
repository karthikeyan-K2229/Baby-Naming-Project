import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-display-user',
  templateUrl: './display-user.component.html',
  styleUrls: ['./display-user.component.css']
})
export class DisplayUserComponent implements OnInit {
  users!: User[] ;
  
  constructor(private userService: UserService,private _loginService : LoginService,) { }

  ngOnInit(): void {
    this.getUsers();
  }
  private getUsers(){
    this.userService.getUsersList().subscribe(data =>{
      this.users=data;
      console.log(data);
    })
  }
 // updateUser(id: number){
  //  this.router.navigate(['update-user',id])
  //}

  deleteUser(id:number){
    this.userService.deleteUser(id).subscribe(data=>{
      console.log(data);
      alert("deleted successfully");
      this.getUsers();
      
    })
  }
  logout()
  {
    this._loginService.Logout();
  }
}

