import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VelocistaComponent } from './velocista.component/velocista.component';
import { AggiungiComponent } from './aggiungi.component/aggiungi.component';


const routes: Routes = [
  { path: 'velocisti', component: VelocistaComponent },
  { path: 'aggiungi', component: AggiungiComponent },
  { path: '', redirectTo: '/velocisti', pathMatch: 'full' }, // default
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
