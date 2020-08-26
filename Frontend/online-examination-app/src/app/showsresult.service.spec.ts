import { TestBed } from '@angular/core/testing';

import { ShowsresultService } from './showsresult.service';

describe('ShowsresultService', () => {
  let service: ShowsresultService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShowsresultService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
