import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AddminfoodService } from '../addminfood.service';
import { Adminfood } from '../adminfood';
import { LoginService } from '../login.service';


@Component({
  selector: 'app-adminfood',
  templateUrl: './adminfood.component.html',
  styleUrls: ['./adminfood.component.css']
})
export class AdminfoodComponent implements OnInit {
  Addsfood: any;
  users!: Adminfood[] ;
  

  constructor(private _loginService : LoginService,private router: Router,private formBuilder: FormBuilder,private adminfoodservice:AddminfoodService) {this.forms(); }

  ngOnInit(): void { 
    
  }
  forms()
  {
    this.Addsfood = this.formBuilder.group({
      foodname:['',[Validators.required,Validators.pattern("^[a-zA-Z-' ']*")]],
      imageurl:['',[Validators.required]],
      category:['',[Validators.required]],
      price:['',[Validators.required,Validators.pattern("^[0-9.]*")]],
    })
  }
  AddTheme()
  {
    console.log(this.Addsfood.value);
    this.adminfoodservice.Addingtheme(this.Addsfood.value).subscribe(data=>{
      alert("Food Added Successfully")
      //this.getUsers();
      this.Addsfood.reset();
      this.router.navigate(['/viewfood']);

    
  },error=>alert("Food name already exits "));
    }

    logout()
    {
      this._loginService.Logout();
    }
}
