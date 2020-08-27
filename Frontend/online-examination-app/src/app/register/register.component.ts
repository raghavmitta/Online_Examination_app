import { Component, OnInit, NgModule } from '@angular/core';
import { Register, Login } from '../register';
//import { HttpClientModule } from '@angular/common/http';
import { RegisterService } from '../register.service';
import { FormsModule } from '@angular/forms'; 



@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent{

  data: any;
  constructor(private service: RegisterService){}
  register: Register= new Register();

    addUser(){
      this.register.login.acesstype="Student";
      this.service.addUser(this.register).subscribe(this.data);
      alert(this.data);
    }
}

