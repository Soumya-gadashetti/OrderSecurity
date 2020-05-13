import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../models/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  baseUrl:string;
  constructor(private httpClient: HttpClient) {
    this.baseUrl = "http://localhost:8765/order-service/order";
   }

   getOrder() : Observable<Order[]>{
     return this.httpClient.get<Order[]>(this.baseUrl +"/all")
   }

   getOrderById(orderId:number) :Observable<Order>{
    return this.httpClient.get<Order>(`${this.baseUrl +"byId"}/${orderId}`);
  }

   addOrder(order:Order) :Observable<Order>{
     return this.httpClient.post<Order>(this.baseUrl +"/add",order);
   }

   updateOrder(order:Order) :Observable<Order>{
    return this.httpClient.put<Order>(this.baseUrl +"/update",order);
  }

    deleteOrder(orderId:number) :Observable<void>{
        return this.httpClient.delete<void>(`${this.baseUrl +"/deleteId"}/${orderId}`);
    }
}
