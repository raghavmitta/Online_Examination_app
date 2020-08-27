import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Register } from './register';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  id: number;
  router: Router;
  constructor(private http: HttpClient) { }

  addUser(register: Register){
    let url='http://localhost:8585/RegisterUser.api';
    return this.http.post(url, register);

    
}
}
