import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoriaAbitiComponent } from './categoria-abiti.component';

describe('CategoriaAbitiComponent', () => {
  let component: CategoriaAbitiComponent;
  let fixture: ComponentFixture<CategoriaAbitiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CategoriaAbitiComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CategoriaAbitiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
