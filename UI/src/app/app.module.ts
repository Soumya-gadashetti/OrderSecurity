import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashBoardComponent } from './dash-board/dash-board.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { OrderFormComponent } from './order-form/order-form.component';
import { OrdersListComponent } from './orders-list/orders-list.component';

import { LoginComponent } from './login/login.component';
import { HttpInterceptorService } from './services/http-interceptor.service';
import { LogoutComponent } from './logout/logout.component';
import { MenuComponent } from './menu/menu.component';

@NgModule({
  declarations: [
    AppComponent,
    DashBoardComponent,
    PageNotFoundComponent,
    OrderFormComponent,
    OrdersListComponent,
    LoginComponent,
    LogoutComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: HttpInterceptorService,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
