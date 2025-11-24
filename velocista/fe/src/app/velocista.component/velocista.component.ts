import { Component, OnInit } from '@angular/core';
import { VelocistaService } from '../services/velocista.service';
import { VelocistaDTO } from '../models/velocista-dto.model';

@Component({
  selector: 'app-velocista.component',
  standalone: false,
  templateUrl: './velocista.component.html',
  styleUrls: ['./velocista.component.css'],
})
export class VelocistaComponent implements OnInit {
  velocisti: VelocistaDTO[] = [];
  etaFiltro?: number;

  constructor(private velocistaService: VelocistaService) {}

  ngOnInit(): void {
    this.caricaVelocisti();
  }
  caricaVelocisti(): void {
    this.velocistaService.getVelocisti(this.etaFiltro).subscribe((data) => {
      this.velocisti = data;
    });
  }

   filtra(): void {
    this.caricaVelocisti();
  }

  
}
