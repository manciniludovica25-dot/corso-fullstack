import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { HomeComponent } from './home.component/home.component';
import { CategoriaVeicoliComponent } from './categoria-veicoli.component/categoria-veicoli.component';

@NgModule({
  declarations: [
    App,
    HomeComponent,
    CategoriaVeicoliComponent
  ],
  imports: [
     BrowserModule,
    HttpClientModule,     // <─ AGGIUNGI QUESTO NEGLI IMPORT
    AppRoutingModule,
  ],
  providers: [
    provideBrowserGlobalErrorListeners()
  ],
  bootstrap: [App]
})
export class AppModule { }
