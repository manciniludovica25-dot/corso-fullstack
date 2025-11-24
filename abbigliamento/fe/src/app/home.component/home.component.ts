import { Component } from '@angular/core';


interface CategoriaAbito {
  codice: string;   // es. 'pd'
  descrizione: string; // es. 'Pantaloni donna'
}


@Component({
  selector: 'app-home.component',
  standalone: false,
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {

   categorie: CategoriaAbito[] = [
    { codice: 'pd', descrizione: 'Pantaloni donna' },
    { codice: 'pu', descrizione: 'Pantaloni uomo' },
    { codice: 'cd', descrizione: 'Camicie donna' },
    { codice: 'cu', descrizione: 'Camicie uomo' },
    { codice: 'md', descrizione: 'Maglioni donna' },
    { codice: 'mu', descrizione: 'Maglioni uomo' },
  ];

}
