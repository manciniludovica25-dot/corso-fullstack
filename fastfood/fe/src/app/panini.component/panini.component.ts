import { Component, OnInit } from '@angular/core';
import { Prodotto } from '../models/prodotto.model';
import { ProdottoService } from '../services/prodottoservice';

@Component({
  selector: 'app-panini',                    
  standalone: false,
  templateUrl: './panini.component.html',
  styleUrls: ['./panini.component.css'],      
})
export class PaniniComponent implements OnInit {

  prodotti: Prodotto[] = [];

  constructor(private prodottoService: ProdottoService) {}

  ngOnInit(): void {
    this.prodottoService.getProdottiPerCategoria('panino')
      .subscribe((prodotti) => {
        this.prodotti = prodotti;
      });
  }
}
