import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Veicolo } from '../models/veicolo.model';

@Injectable({
  providedIn: 'root',
})
export class VeicoloService {

  private apiUrl = 'http://localhost:8080/api/veicoli';

  constructor(private http: HttpClient) {}

  getVeicoli(): Observable<Veicolo[]> {
    return this.http.get<Veicolo[]>(this.apiUrl);
  }

  getVeicoliPerCategoria(categoria: string): Observable<Veicolo[]> {
    return this.http.get<Veicolo[]>(`${this.apiUrl}/categoria/${categoria}`);
  }
}
