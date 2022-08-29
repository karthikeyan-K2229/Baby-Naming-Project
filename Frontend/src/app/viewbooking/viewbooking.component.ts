import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookeventService } from '../bookevent.service';
import { LoginService } from '../login.service';

@Component({ 
  selector: 'app-viewbooking',
  templateUrl: './viewbooking.component.html',
  styleUrls: ['./viewbooking.component.css']
})
export class ViewbookingComponent implements OnInit {

  constructor(private _loginService:LoginService, private _bookEvent: BookeventService, private _router:Router) { }

  events:any;

  ngOnInit(): void {
    this._bookEvent.getById(this._loginService.User.id).subscribe((data)=>{
      console.log(data);
      this.events=data;
    })
  }

  logout()
  {
    this._loginService.Logout();
  }

  test()
  {
    console.log("test");
    const button = document.querySelector('.test');
    console.log(button['disabled'])
  }

  edit(id)
  {
      this._router.navigate(["editEvent",id]);
  }
  

  deleteEvent(event: any) {
    this._bookEvent.deleteEvent(event.eventid).subscribe((data)=>{

      this._bookEvent.getById(this._loginService.User.id).subscribe((data)=>{
        console.log(data);
        this.events=data;
      })

    })

    
  }
  


}
