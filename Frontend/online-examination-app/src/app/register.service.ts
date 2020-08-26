import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Register } from './register';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  addUser(register: Register){
    let url='http://localhost:8181/OnlineExaminationApp/RegisterUser.api';
    return this.http.post(url, register);
}
}
