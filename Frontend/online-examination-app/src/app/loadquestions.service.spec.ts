import { TestBed } from '@angular/core/testing';

import { LoadquestionsService } from './loadquestions.service';

describe('LoadquestionsService', () => {
  let service: LoadquestionsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoadquestionsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
