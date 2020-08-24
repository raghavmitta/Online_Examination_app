import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExaminationInstructionComponent } from './examination-instruction.component';

describe('ExaminationInstructionComponent', () => {
  let component: ExaminationInstructionComponent;
  let fixture: ComponentFixture<ExaminationInstructionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExaminationInstructionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExaminationInstructionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
