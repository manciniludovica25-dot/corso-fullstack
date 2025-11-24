import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Piatto } from '../models/piatto.model';


@Injectable({
  providedIn: 'root',
})
export class Piattoservice {
  private apiUrl = 'http://localhost:8080/api/piatti'; // adatta al tuo backend

  constructor(private http: HttpClient) {}

  getPiatti(): Observable<Piatto[]> {
    return this.http.get<Piatto[]>(this.apiUrl);
  }

  getPiattiPerCategoria(categoria: string): Observable<Piatto[]> {
    return this.http.get<Piatto[]>(`${this.apiUrl}/categoria/${categoria}`);
  }
}

