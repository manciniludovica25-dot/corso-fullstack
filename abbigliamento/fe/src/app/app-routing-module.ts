import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home.component/home.component';
import { CategoriaAbitiComponent } from './categoria-abiti.component/categoria-abiti.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'abiti/:tipo', component: CategoriaAbitiComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
