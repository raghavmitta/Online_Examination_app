import { element } from "protractor";
import { ShowsresultService } from "./../showsresult.service";
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-showresult',
  templateUrl: './showresult.component.html',
  styleUrls: ['./showresult.component.css']
})
export class ShowresultComponent implements OnInit {
store:result=new result()
  constructor(private showservice:ShowsresultService) {
    this.load()
   }

  load(){
    this.showservice.show().subscribe(element=>{
      this.store=element
    })
  }
  ngOnInit(): void {
  }

}

export class result{
  examlevel:number
  score:number
  status:string
}