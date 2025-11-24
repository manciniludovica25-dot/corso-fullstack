import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { VeicoloService } from '../services/veicolo.service';
import { Veicolo } from '../models/veicolo.model';


@Component({
  selector: 'app-categoria-veicoli.component',
  standalone: false,
  templateUrl: './categoria-veicoli.component.html',
  styleUrls: ['./categoria-veicoli.component.css'],
})
export class CategoriaVeicoliComponent implements OnInit {

  categoria = '';
  veicoli: Veicolo[] = [];
  loading = false;
  error: string | null = null;

  constructor(
    private route: ActivatedRoute,
    private veicoloService: VeicoloService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.categoria = params.get('categoria') ?? '';
      if (!this.categoria) {
        this.veicoli = [];
        return;
      }

      this.loading = true;
      this.error = null;

      this.veicoloService.getVeicoliPerCategoria(this.categoria)
        .subscribe({
          next: vs => {
            this.veicoli = vs;
            this.loading = false;
          },
          error: () => {
            this.error = 'Errore nel caricamento dei veicoli';
            this.loading = false;
          }
        });
    });
  }
}