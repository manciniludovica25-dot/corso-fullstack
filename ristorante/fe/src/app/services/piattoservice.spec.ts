import { TestBed } from '@angular/core/testing';

import { Piattoservice } from './piattoservice';

describe('Piattoservice', () => {
  let service: Piattoservice;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Piattoservice);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
