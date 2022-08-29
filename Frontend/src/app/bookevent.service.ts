import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bookevent } from './bookevent';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class BookeventService {
  baseUrl="http://localhost:7000/user/bookTheme";

  constructor(private httpClient: HttpClient , private loginService: LoginService) { }

  BookingEvent(bookevent: Bookevent) :Observable<Object>
  {
    console.log(bookevent);
    return this.httpClient.post(`${this.baseUrl}`,bookevent);
  
  }
  public getById(id)
  {
    return this.httpClient.get('http://localhost:7000/user/viewBookedTheme/'+id);
  }

  public getByEventId(id)
  {
    return this.httpClient.get('http://localhost:7000/user/getBookedTheme/'+id);
  }
  
  public deleteEvent(id) {
    return this.httpClient.delete('http://localhost:7000/user/deleteEvent/'+id);
  }
  public updateEvent(event,eventId) {
    return this.httpClient.put('http://localhost:7000/user/UpdateBookedTheme/'+eventId,event);
  }
}