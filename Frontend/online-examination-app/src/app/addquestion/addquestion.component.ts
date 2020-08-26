import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/_service/admin.service';

@Component({
  selector: 'addquestion',
  templateUrl: './addquestion.component.html',
  styleUrls: ['./addquestion.component.css']
})
export class AddquestionComponent implements OnInit {


  csvFile: any;
  exam_id : any= 2;

  constructor(private service: AdminService) { }

  ngOnInit(): void {
  }

  onFileChange(event){
    this.csvFile = event.target.files[0];
  }

  upload() {
    let formData: FormData = new FormData();
    formData.append('exam_id', this.exam_id);
    formData.append('csvFile', this.csvFile);
    console.log(formData.get('csvFile'));
    console.log(formData.get('exam_id'));
  
    this.service.upload(formData).subscribe(data => {
      alert(JSON.stringify(data));
    })
  }
}