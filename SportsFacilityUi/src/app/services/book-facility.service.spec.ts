import { TestBed } from '@angular/core/testing';

import { BookFacilityService } from './book-facility.service';

describe('BookFacilityService', () => {
  let service: BookFacilityService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BookFacilityService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
