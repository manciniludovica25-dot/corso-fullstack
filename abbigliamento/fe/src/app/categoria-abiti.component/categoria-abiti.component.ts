import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AbitoService } from '../services/abito.service';
import { Abito } from '../models/abito.model';


@Component({
  selector: 'app-categoria-abiti.component',
  standalone: false,
  templateUrl: './categoria-abiti.component.html',
   styleUrls: ['./categoria-abiti.component.css'],
})
export class CategoriaAbitiComponent implements OnInit {

  tipo = '';
  abiti: Abito[] = [];
  loading = false;
  error: string | null = null;

  constructor(
    private route: ActivatedRoute,
    private abitoService: AbitoService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.tipo = params.get('tipo') ?? '';
      if (!this.tipo) {
        this.abiti = [];
        return;
      }

      this.loading = true;
      this.error = null;

      this.abitoService.getAbitiPerTipo(this.tipo)
        .subscribe({
          next: (dati) => {
            this.abiti = dati;
            this.loading = false;
          },
          error: () => {
            this.error = 'Errore nel caricamento degli abiti';
            this.loading = false;
          }
        });
    });
  }
}
