import { result } from "./showresult/showresult.component";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ShowsresultService {

  constructor(private http:HttpClient) {} 
  show():Observable<result>
  {
    return this.http.get<result>("http://localhost:8585/getresult/101/1");
  }
   
}
