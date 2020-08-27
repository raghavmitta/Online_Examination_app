import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StuportalComponent } from './stuportal.component';

describe('StuportalComponent', () => {
  let component: StuportalComponent;
  let fixture: ComponentFixture<StuportalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StuportalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StuportalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
