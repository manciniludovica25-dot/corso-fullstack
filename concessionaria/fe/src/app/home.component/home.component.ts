import { Component } from '@angular/core';

@Component({
  selector: 'app-home.component',
  standalone: false,
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {

    categorie: string[] = ['automobile', 'motocicletta', 'furgone'];

}
