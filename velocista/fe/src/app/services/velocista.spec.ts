import { TestBed } from '@angular/core/testing';

import { VelocistaDTO } from '../models/velocista-dto.model';

describe('Velocista', () => {
  let service: VelocistaDTO;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VelocistaDTO);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
