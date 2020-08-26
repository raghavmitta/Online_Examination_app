import { exams } from "./selectexam/selectexam.component";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SelectexamService {
  
  constructor(private http:HttpClient) {}
  get():Observable<Array<exams>>
  {
return this.http.get<Array<exams>>("http://localhost:8585/getexamlist/1")
  }
}

