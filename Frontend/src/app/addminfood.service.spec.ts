import { TestBed } from '@angular/core/testing';

import { AddminfoodService } from './addminfood.service';

describe('AddminfoodService', () => {
  let service: AddminfoodService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddminfoodService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
