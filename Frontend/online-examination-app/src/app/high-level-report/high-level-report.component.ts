import { Component, OnInit } from '@angular/core';
import { HighLevelReport } from "src/_model/high_level_report";
import { ReportService } from "src/_service/report.service";

@Component({
  selector: 'app-high-level-report',
  templateUrl: './high-level-report.component.html',
  styleUrls: ['./high-level-report.component.css']
})
export class HighLevelReportComponent implements OnInit {
  high_level_report:HighLevelReport[];
  stu_id:number=1;
  constructor(private service: ReportService) { }

  ngOnInit(): void {
    console.log(this.stu_id);
    this.service.getStudentDetails(this.stu_id).subscribe((data: any) => {
      this.high_level_report=data;
    }
    );
  }

}
