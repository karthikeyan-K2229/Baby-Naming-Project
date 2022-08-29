import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Adminfood } from './adminfood';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AddminfoodService {


  constructor(private httpClient: HttpClient) { }
  Addingtheme(addfood : Adminfood ) :Observable<Object>
  {
    console.log(addfood);
    
    return this.httpClient.post<any>(`http://localhost:7000/admin/addfood`,addfood);
  }

  getUsersList(): Observable<Adminfood[]>{
    return this.httpClient.get<Adminfood[]>(`http://localhost:7000/admin/getfood`);
  }

  deleteUser(id:number): Observable<Object>{
    return this.httpClient.delete(`http://localhost:7000/admin/deletefood/${id}`);
  }
  updateUser(id: number,user:Adminfood): Observable<Object>{
    return this.httpClient.put(`http://localhost:7000/admin/updatefood/${id}`,user);
  }
  getUserById(id:number):Observable<Adminfood>{
    return this.httpClient.get<Adminfood>(`http://localhost:7000/admin/getfoodbyid/${id}`);
  }


}
