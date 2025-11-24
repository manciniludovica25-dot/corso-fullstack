import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Abito } from '../models/abito.model';

@Injectable({
  providedIn: 'root',
})
export class AbitoService {

  private apiUrl = 'http://localhost:8080/api/abiti';

  constructor(private http: HttpClient) {}

  getAbiti(): Observable<Abito[]> {
    return this.http.get<Abito[]>(this.apiUrl);
  }

  getAbitiPerTipo(tipo: string): Observable<Abito[]> {
    return this.http.get<Abito[]>(`${this.apiUrl}/tipo/${tipo}`);
  }
}
