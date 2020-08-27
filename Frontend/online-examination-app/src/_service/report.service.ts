import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Injectable({
    providedIn: 'root'
  })

  export class ReportService {

    constructor(private http: HttpClient) { }

    getStudentDetails(stu_id : number){
        var url="http://localhost:8585/highlevelreport/" + stu_id;
        return this.http.get(url);
      }
  }