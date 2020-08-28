import { Component, OnInit } from '@angular/core';
import { Exam_db } from "src/_model/exam_db";
import { Question_Bank } from "src/_model/question_bank";
import { AdminService } from "src/_service/admin.service";
import { Router } from '@angular/router';
@Component({
  selector: 'removequestion',
  templateUrl: './removequestion.component.html',
  styleUrls: ['./removequestion.component.css']
})
export class RemoveQuestionComponent implements OnInit {
  exam_db: Exam_db[];
  question_bank: Question_Bank[];
  exam_id: number;
  selectedQuestionId: number[];
  toDelete: number[] = [];
  visible: number;
  counter: number = 0;
  constructor(private service: AdminService, private router: Router) { }

  ngOnInit(): void {
    this.service.getSubjectList().subscribe((data: any) => {
      this.exam_db = data;
    }
    );
  }

  addId(row) {
    let index = this.toDelete.indexOf(row);
    if (index == -1) {
      this.toDelete.push(row);                // Adding database Index
    } else {
      this.toDelete.splice(index, 1);
    }

  }

  readQuestionList() {
    console.log(this.exam_id);
    this.service.getQuestionList(this.exam_id).subscribe((data: any) => {
      this.question_bank = data;
      this.visible = 1;
    });
  }

  deleteQues() {
    this.service.deleteQuestion(this.toDelete).subscribe((data: any) => {
      this.question_bank = data;
      this.router.navigate(['success'])
    });
  }

}
