import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategorieComponent } from './categorie.component/categorie.component';
import { PaniniComponent } from './panini.component/panini.component';

const routes: Routes = [
  { path: 'categorie', component: CategorieComponent },
  { path: 'prodotti/:categoria', component: PaniniComponent }, // meglio rinominarlo in component generico
  { path: '', redirectTo: 'categorie', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
