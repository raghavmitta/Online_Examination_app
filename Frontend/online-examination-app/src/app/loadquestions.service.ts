import { question } from "./load-questions/load-questions.component";
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoadquestionsService {

  constructor(private http:HttpClient) {} 
  getquestion():Observable<Array<question>>
  {
    return this.http.get<Array<question>>("http://localhost:8585/beginexam/101");
  }
}
