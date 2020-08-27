import { Component, NgModule } from '@angular/core';
import { Login } from '../login';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { stringify } from '@angular/compiler/src/util';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {

  login: Login= new Login();
  data: number;
  name1: string;
  constructor(private service: LoginService,private router: Router) { }

  LoginUser(){
    this.service.LoginUser(this.login).subscribe(r=>{
      this.data=<number>r.statusCode;
      if(this.data==-1)
      {
       alert("Incorrect details");
      }
      else if(this.data==-2)
      {
      alert("Welcome Admin");
        
        sessionStorage.setItem("name", "admin"); //Storing admin info in session          
        sessionStorage.loggedIn = true;
         this.router.navigate(['admin/admin-dashboard']);
       }
        else{
          alert("Welcome Student");
          this.name1=r.name;
          sessionStorage.setItem("name", this.name1); //Storing user info in session          
          sessionStorage.loggedIn = true;
          this.router.navigate(['stuportal']);
        }
    })
  }
}
