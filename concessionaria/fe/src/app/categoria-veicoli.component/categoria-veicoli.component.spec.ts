import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoriaVeicoliComponent } from './categoria-veicoli.component';

describe('CategoriaVeicoliComponent', () => {
  let component: CategoriaVeicoliComponent;
  let fixture: ComponentFixture<CategoriaVeicoliComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CategoriaVeicoliComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CategoriaVeicoliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
