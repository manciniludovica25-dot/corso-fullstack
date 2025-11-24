import { TestBed } from '@angular/core/testing';

import { Prodottoservice } from './prodottoservice';

describe('Prodottoservice', () => {
  let service: Prodottoservice;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Prodottoservice);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
