import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OrdersListComponent } from './orders-list/orders-list.component';
import { OrderFormComponent } from './order-form/order-form.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path:'list',component:OrdersListComponent,pathMatch:'full'},
  {path:'addOrder',component:OrderFormComponent},
  {path:'editOrder/:id',component:OrderFormComponent},
  {path: 'login', component: LoginComponent},
  {path: '', component: LoginComponent},
  {path: 'logout', component: LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
