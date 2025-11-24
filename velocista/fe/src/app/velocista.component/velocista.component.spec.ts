import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VelocistaComponent } from './velocista.component';

describe('VelocistaComponent', () => {
  let component: VelocistaComponent;
  let fixture: ComponentFixture<VelocistaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [VelocistaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VelocistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
