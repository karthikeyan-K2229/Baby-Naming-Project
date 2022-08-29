import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Feedback } from './feedback';
import { User } from './user';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseURL="http://localhost:7000";

  constructor(private httpClient: HttpClient) { }

  getUsersList(): Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.baseURL}/getAllUsers`);
  }

 public getUser(id)
 {
  return this.httpClient.get(`${this.baseURL}/user/`+id);
 }

 sentFeedBack(feedback:Feedback):Observable<Object>
 {
  console.log(feedback);
  return this.httpClient.post<any>(`${this.baseURL}/feedback`,feedback);
 }
  deleteUser(id:number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/delete/${id}`);
  }

  public getFeedback(): Observable<Feedback[]>{
    return this.httpClient.get<Feedback[]>(`${this.baseURL}/allFeedBack`);
  }

}
