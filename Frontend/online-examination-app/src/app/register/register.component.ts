import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Register } from '../register';
declare function print_state(): any;
declare function print_city(): any;
declare function register(): any;

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  
})
export class RegisterComponent implements OnInit {

  register: Register= new Register();
  constructor() { }

  ngOnInit(){
    print_state();
    print_city();
    register();

  }
}
