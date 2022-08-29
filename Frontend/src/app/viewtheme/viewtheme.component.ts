import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AddmenuService } from '../addmenu.service';
import { Addtheme } from '../addtheme';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-viewtheme',
  templateUrl: './viewtheme.component.html',
  styleUrls: ['./viewtheme.component.css']
})
export class ViewthemeComponent implements OnInit {
  addmenu:Addtheme=new Addtheme();
  themes: Addtheme[];

  constructor(private _loginService : LoginService,private addthemeservice:AddmenuService,private  router : Router) { }

  ngOnInit(): void { this.gettheme();
  }
  public gettheme()
  {
   this.addthemeservice.getAllThemes().subscribe(data =>
  {
    this.themes=data;
  })
  }

deleteUser(themeid:number){
this.addthemeservice.deleteUser(themeid).subscribe(data=>{
  console.log(data);
  alert("deleted successfully");
  this.gettheme();
})
}
updateUser(themeid: number){
this.router.navigate(['updatetheme',themeid])
}
logout()
    {
      this._loginService.Logout();
    }
}
