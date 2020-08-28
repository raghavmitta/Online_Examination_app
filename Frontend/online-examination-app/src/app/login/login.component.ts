import { Component, NgModule } from '@angular/core';
import { Login } from '../login';
import { LoginService } from '../login.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {

  login: Login= new Login();
  data: any;
  constructor(private service: LoginService) { }

  LoginUser(){
    this.service.LoginUser(this.login).subscribe(this.data);
      alert(this.data);
  }

}
