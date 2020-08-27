import { Injectable } from '@angular/core';
import { Login } from './login';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
 
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  idobj: ID= new ID();
  router: Router;
  constructor(private http : HttpClient) { }
  LoginUser(login: Login){
    let url='http://localhost:8585/Login.api';
    return this.http.post(url, login);
    /*
    if(this.idobj.id=-1)
    {
      alert("Invalid Login");
      this.router.navigate(['register']);
    }
    if(this.idobj.id=-2)
    {
      alert("Welcome Admin");
      this.router.navigate(['admin/admin-dashboard']);
    }
    else
    {
      alert("Welcome Student");
      this.router.navigate(['stuportal'])
    }
    */
  }
}

class ID{
  id:number;
}
