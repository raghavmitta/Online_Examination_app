
import { Observable } from "rxjs";
import { LoadquestionsService } from "./../loadquestions.service";
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'load-questions',
  templateUrl: './load-questions.component.html',
  styleUrls: ['./load-questions.component.css']
})
export class LoadQuestionsComponent implements OnInit {

  constructor(private loadservice:LoadquestionsService) { }


  ngOnInit(): void {
  }
loadquestions(){
   this.loadservice.getquestion().subscribe(data=>{
     data.forEach(element=>{
       console.log(element.question);
     })

   });
    

}
}
export class question{
question:string;
response:string;
options:Array<optionlist>;
responseid:number;

}
export class optionlist{
  option:string
}