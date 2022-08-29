import { Component, OnInit } from '@angular/core';
import { NavigationExtras } from '@angular/router';
;
import { AddmenuService } from '../addmenu.service';
import { Addtheme } from '../addtheme';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  themes: Addtheme[];
  themeName: any;

  constructor(private addthemeservice:AddmenuService,private _loginService : LoginService ) { }

  ngOnInit(): void {
    this.getthemes();
  }
public getthemes()
{
  this.addthemeservice.getAllThemes().subscribe(data =>
    {
      this.themes=data;
     // console.log(data);
    })
}
Search()
{
  if(this.themeName=="")
  {
    this.ngOnInit();
  }else
  {
    this.themes=this.themes.filter(res=>{
      return res.themeName.toLocaleLowerCase().match(this.themeName.toLocaleLowerCase());
    })
  }
}
logout()
{
  this._loginService.Logout();
}
}
