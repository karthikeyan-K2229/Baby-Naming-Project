import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


import { Addtheme } from './addtheme';


@Injectable({
  providedIn: 'root'
})
export class AddmenuService {
 

  constructor(private httpClient: HttpClient) { }
  Addingtheme(addtheme : Addtheme ) :Observable<Object>
  {
    console.log(addtheme);
    
    return this.httpClient.post<any>(`http://localhost:7000/admin/addtheme`,addtheme);
  }

  getAllThemes(): Observable<Addtheme[]>
  {
    return this.httpClient.get<Addtheme[]>(`http://localhost:7000/user/getAllThemes`);
  }

  deleteUser(themeid:number): Observable<Object>{
    return this.httpClient.delete(`http://localhost:7000/admin/deletetheme/${themeid}`);
  }
  getUserById(themeid:number):Observable<Addtheme>{
    return this.httpClient.get<Addtheme>(`http://localhost:7000/admin/getthemebyid/${themeid}`);
  }

  updateUser(themeid: number,user:Addtheme): Observable<Object>{
    return this.httpClient.put(`http://localhost:7000/admin/updatetheme/${themeid}`,user);
  }
}
