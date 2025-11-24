import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Prodotto } from '../models/prodotto.model';

@Injectable({
  providedIn: 'root',
})
export class ProdottoService {
  private apiUrl = 'http://localhost:8080/api/prodotto'; // adatta al tuo backend

  constructor(private http: HttpClient) {}

  // Tutti i prodotti (per ricavare le categorie nella pagina iniziale)
  getProdotti(): Observable<Prodotto[]> {
    return this.http.get<Prodotto[]>(this.apiUrl);
  }

  // Prodotti filtrati per categoria (per la pagina "schede prodotto")
  getProdottiPerCategoria(categoria: string): Observable<Prodotto[]> {
    return this.http.get<Prodotto[]>(`${this.apiUrl}/categoria/${categoria}`);
  }
}
