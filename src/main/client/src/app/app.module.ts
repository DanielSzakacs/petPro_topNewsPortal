import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MainPageComponent } from './main-page/main-page.component';
import {HttpClientModule} from "@angular/common/http";
import {CookieService} from "ngx-cookie-service";

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    CookieService
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
