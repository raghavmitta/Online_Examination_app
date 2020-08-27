import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminSuccessComponent } from './admin-success.component';

describe('AdminSuccessComponent', () => {
  let component: AdminSuccessComponent;
  let fixture: ComponentFixture<AdminSuccessComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminSuccessComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminSuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
