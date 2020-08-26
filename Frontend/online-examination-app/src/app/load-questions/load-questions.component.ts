import { SaveresponseService } from "./../saveresponse.service";
import { LoadquestionsService } from "./../loadquestions.service";
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'load-questions',
  templateUrl: './load-questions.component.html',
  styleUrls: ['./load-questions.component.css']
})
export class LoadQuestionsComponent implements OnInit {
  qlist:Array<question>=new Array<question>();
  qcurrent:question=new question();
  showquestion:boolean;
  qNo:number=0
  resObject:ResponseDto=new ResponseDto();
  constructor(private loadservice:LoadquestionsService,private saveService:SaveresponseService ) { 
    this.loadquestions();
  }


  ngOnInit(): void {}
  submit(){
      this.qlist.forEach(element=>{
      this.resObject.response_id=element.responseid
      this.resObject.response=element.response
      
      this.saveService.save(this.resObject).subscribe(element=>{element});
    })
  }
  saveresponse(){
    this.resObject.response_id=this.qcurrent.responseid;
    this.resObject.response=this.qcurrent.response;
  
    this.saveService.save(this.resObject).subscribe(element=>{element});
  }
loadquestions(){
   this.loadservice.getquestion().subscribe(element=>{
     element.forEach(q=>{
       this.qlist.push(q)
      })
})
}
next(){
  this.saveresponse()
  if(this.qNo<this.qlist.length-1)
  {
  this.qNo++
  }
  alert(JSON.stringify(this.qcurrent.response))
  this.showquestions()
}
previous(){
  this.saveresponse()
  if(this.qNo>0)
  {
  this.qNo--
  }
  this.showquestions()
}
showquestions(){
  
  this.qcurrent=this.qlist[this.qNo]
    alert(JSON.stringify(this.qcurrent))
    this.showquestion=true;
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
export class ResponseDto
{
  response_id:number;
  response:string 

}
