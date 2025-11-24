import { Component, OnInit } from '@angular/core';
import { Prodotto } from '../models/prodotto.model';
import { ProdottoService } from '../services/prodottoservice';

@Component({
  selector: 'app-categorie',                       
  standalone: false,
  templateUrl: './categorie.component.html',
  styleUrls: ['./categorie.component.css'],        
})
export class CategorieComponent implements OnInit {

  prodotti: Prodotto[] = [];
  categorie: string[] = [];

  constructor(private prodottoService: ProdottoService) {}

  ngOnInit(): void {
    this.prodottoService.getProdotti().subscribe((prodotti) => {
      this.prodotti = prodotti;

      // estraggo le categorie distinte, assumendo campo "categoria" nel model
      this.categorie = [...new Set(prodotti.map(p => p.categoria))];
    });
  }
}
