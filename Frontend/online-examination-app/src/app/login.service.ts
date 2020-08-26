import { Injectable } from '@angular/core';
import { Login } from './login';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http : HttpClient) { }
  LoginUser(login: Login){
    let url='http://localhost:8181/OnlineExaminationApp/Login.api';
    return this.http.post(url, login);
  }
}
