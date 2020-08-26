import { Router} from "@angular/router";
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'examination-instruction',
  templateUrl: './examination-instruction.component.html',
  styleUrls: ['./examination-instruction.component.css']
})
export class ExaminationInstructionComponent implements OnInit {

  navigate(){
    this.router.navigate(['loadquestion']);
  }
  constructor(private router:Router) { }

  ngOnInit(): void {
  }

}
