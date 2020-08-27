import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }

  getSubjectList(){
    var url="http://localhost:8585/subjectlist";
    return this.http.get(url);
  }

  getQuestionList(exam_id : number){
    var url="http://localhost:8585/fetchquestion/" + exam_id;
    return this.http.get(url);
  }

  upload(formData: FormData) {
    let url='http://localhost:8585/file-upload';
    return this.http.post(url, formData);
  }
}
