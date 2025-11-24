import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'; 
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { VelocistaComponent } from './velocista.component/velocista.component';
import { AggiungiComponent } from './aggiungi.component/aggiungi.component';


@NgModule({
  declarations: [
    App,
    VelocistaComponent,
    AggiungiComponent,
   
  ],
  imports: [
    BrowserModule,
     FormsModule,          // 👈 aggiunto qui
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners()
  ],
  bootstrap: [App]
})
export class AppModule { }
