import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { AddminfoodService } from '../addminfood.service';
import { Adminfood } from '../adminfood';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-viewfood',
  templateUrl: './viewfood.component.html',
  styleUrls: ['./viewfood.component.css']
})
export class ViewfoodComponent implements OnInit {
  users!: Adminfood[] ;

  constructor(private _loginService : LoginService,private router: Router,private formBuilder: FormBuilder,private adminfoodservice:AddminfoodService) { }

  ngOnInit(): void {this.getUsers();
  }
  private getUsers(){
    this.adminfoodservice.getUsersList().subscribe(data =>{
      this.users=data;
    })
  }
  deleteUser(id:number){
    this.adminfoodservice.deleteUser(id).subscribe(data=>{
      console.log(data);
      alert("deleted successfully");
      this.getUsers();
    })
  }
  updateUser(id: number){
    this.router.navigate(['updatefood',id])
  }
  logout()
    {
      this._loginService.Logout();
    }
}

