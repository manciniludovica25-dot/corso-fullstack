import { Component } from '@angular/core';
import { VelocistaService } from '../services/velocista.service';
import { VelocistaDTO } from '../models/velocista-dto.model';
import { Router } from '@angular/router';


@Component({
  selector: 'app-aggiungi.component',
  standalone: false,
  templateUrl: './aggiungi.component.html',
  styleUrl: './aggiungi.component.css'
})
export class AggiungiComponent {

   nuovo: VelocistaDTO = { nominativo: '', eta: 0, record: 0 };

     constructor(private velocistaService: VelocistaService, private router: Router) {}

      salva(): void {
    this.velocistaService.addVelocista(this.nuovo).subscribe({
      next: () => {
        alert('Velocista aggiunto con successo!');
        this.router.navigate(['/velocisti']); // torna alla lista
      },
      error: (err) => {
        console.error(err);
        alert('Errore nel salvataggio');
      }
    });
  }

}
