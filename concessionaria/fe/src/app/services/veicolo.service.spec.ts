import { TestBed } from '@angular/core/testing';

import { VeicoloService } from './veicolo.service';

describe('VeicoloService', () => {
  let service: VeicoloService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VeicoloService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
