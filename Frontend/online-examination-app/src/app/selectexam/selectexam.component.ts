
import { SelectexamService } from "./../selectexam.service";
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-selectexam',
  templateUrl: './selectexam.component.html',
  styleUrls: ['./selectexam.component.css']
})
export class SelectexamComponent implements OnInit {
qlist:exams[]=new Array<exams>()

  constructor(private service:SelectexamService ) { 
    this.load();
  }
load(){
  this.service.get().subscribe(element=>{
    this.qlist=element
    alert(JSON.stringify(this.qlist))

  })

}
  ngOnInit(): void {
  }

}
export class exams{
  examname:string
  exam:number
  level:number
}
