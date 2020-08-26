import { TestBed } from '@angular/core/testing';

import { SelectexamService } from './selectexam.service';

describe('SelectexamService', () => {
  let service: SelectexamService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SelectexamService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
