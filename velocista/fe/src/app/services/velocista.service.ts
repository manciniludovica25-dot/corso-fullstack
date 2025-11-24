import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { VelocistaDTO } from '../models/velocista-dto.model';


@Injectable({
  providedIn: 'root'
})
export class VelocistaService {
 private apiUrl = 'http://localhost:8080/api/velocisti';

  constructor(private http: HttpClient) {}

  // GET con filtro opzionale per età
  getVelocisti(eta?: number): Observable<VelocistaDTO[]> {
    let params = new HttpParams();
    if (eta != null) {
      params = params.set('eta', eta);
    }
    return this.http.get<VelocistaDTO[]>(this.apiUrl, { params });
  }

  // POST per aggiungere nuovo velocista
  addVelocista(v: VelocistaDTO): Observable<VelocistaDTO> {
    return this.http.post<VelocistaDTO>(`${this.apiUrl}/new`, v);
  }
  
}
