import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Piatto } from '../models/piatto.model';
import { Piattoservice } from '../services/piattoservice';

@Component({
  selector: 'app-categoria.component',
  standalone: false,
  templateUrl: './categoria.component.html',
  styleUrls: [ './categoria.component.css'],
})
export class CategoriaComponent implements OnInit {

  categoria = '';
  piatti: Piatto[] = [];

  constructor(
    private service: Piattoservice,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    // si iscrive ai cambi del parametro :categoria
    this.route.paramMap.subscribe(params => {
      const cat = params.get('categoria');
      this.categoria = cat ?? '';

      if (!this.categoria) {
        this.piatti = [];
        return;
      }

      this.service.getPiattiPerCategoria(this.categoria)
        .subscribe(piatti => {
          this.piatti = piatti;
        });
    });
  }
}