import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'stuportal',
  templateUrl: './stuportal.component.html',
  styleUrls: ['./stuportal.component.css']
})
export class StuportalComponent implements OnInit {

  constructor(private router: Router) { }
  
  ngOnInit(): void {
    sessionStorage.getItem('name');
  }

  finish(){
    sessionStorage.clear()
    this.router.navigate(['login']);
  }
}
