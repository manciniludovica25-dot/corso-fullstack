import { TestBed } from '@angular/core/testing';

import { AbitoService } from './abito.service';

describe('AbitoService', () => {
  let service: AbitoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AbitoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
