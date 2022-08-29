import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';
import { Router } from '@angular/router';
import { UserStorage } from './userStorage';
//import { LoginRequestPayload } from './login/login-request.payload';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  baseUrl="http://localhost:7000/userlogin";

  constructor(private httpClient: HttpClient, private _router : Router) { }
  private _user:UserStorage;
  get User()
  {
    if(this._user==null)
    {
      this.ReadUserFromStorage();
    }
    return this._user;
  }

  public LoginUser(user:User) :Observable<object>
  {
    console.log(user);
    return this.httpClient.post(`${this.baseUrl}`,user,{headers:new HttpHeaders({'Content-Type':'application/json'})});
  }

  public SetUser(user)
  {
    this._user=user;
    this.SetUserLocalStorage();
  }
 
  private SetUserLocalStorage()
  {
    localStorage.setItem('user', JSON.stringify(this._user));
  }

  public ReadUserFromStorage()
  {
      let data=localStorage.getItem('user');
      if(data!=null)
      {
        let jdn=JSON.parse(data);
        this._user=<UserStorage>jdn;
      }
  }

  public Logout()
  {
    this._user=null;
    localStorage.removeItem('user');
    localStorage.removeItem('jwt');
    this._router.navigate(['/login']);
  }


}
