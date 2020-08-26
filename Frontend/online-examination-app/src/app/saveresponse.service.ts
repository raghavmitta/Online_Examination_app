import {ResponseDto} from "./load-questions/load-questions.component";
import {Injectable } from '@angular/core';
import {HttpClientModule,HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class SaveresponseService {

  constructor(private http:HttpClient) {} 
  save(r:ResponseDto){
    let url="http://localhost:8585/saveresponse";
    return this.http.post(url,r)
  }
   
}
