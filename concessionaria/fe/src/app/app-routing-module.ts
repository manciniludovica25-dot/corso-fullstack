import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home.component/home.component';
import { CategoriaVeicoliComponent } from './categoria-veicoli.component/categoria-veicoli.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'veicoli/:categoria', component: CategoriaVeicoliComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
