import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/_service/admin.service';
import { Exam_db } from 'src/_model/exam_db';
import { Router } from '@angular/router';

@Component({
  selector: 'addquestion',
  templateUrl: './addquestion.component.html',
  styleUrls: ['./addquestion.component.css']
})
export class AddquestionComponent implements OnInit {

  exam_db: Exam_db[];
  csvFile: any;
  exam_id : any;

  constructor(private service: AdminService, private router: Router) { }

  ngOnInit(): void {
    this.service.getSubjectList().subscribe((data: any) => {
      this.exam_db = data;
    }
    );
  }

  onFileChange(event){
    this.csvFile = event.target.files[0];
  }

  upload() {
    let formData: FormData = new FormData();
    formData.append('exam_id', this.exam_id);
    formData.append('csvFile', this.csvFile);
    this.service.upload(formData).subscribe(data => {
      this.router.navigate(['success'])
    })
  }
}