import { Router } from "@angular/router";
import { SelectexamService } from "./../selectexam.service";
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'selectexam',
  templateUrl: './selectexam.component.html',
  styleUrls: ['./selectexam.component.css']
})
export class SelectexamComponent implements OnInit {
  ngOnInit(): void {
  }
  next(){

    sessionStorage.setItem("examId",this.select)
    this.route.navigate(['instructions']);
  }
  select:any;
    elist:exams[]=new Array<exams>()
    
      constructor(private service:SelectexamService,private route:Router) { 
        this.load();
      }
    load(){
      this.service.get().subscribe(element=>{
        this.elist=element
        this.select=this.elist[0].exam_id
      })
    }

    
    }
    export class exams{
      examName:string
      exam_id:number
      level:number
    }
