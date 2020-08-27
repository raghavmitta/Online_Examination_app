import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HighLevelReportComponent } from './high-level-report.component';

describe('HighLevelReportComponent', () => {
  let component: HighLevelReportComponent;
  let fixture: ComponentFixture<HighLevelReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HighLevelReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HighLevelReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
