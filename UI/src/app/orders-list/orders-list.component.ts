import { Component, OnInit } from '@angular/core';
import { Order } from '../models/order';
import { OrderService } from '../services/order.service';

@Component({
  selector: 'app-orders-list',
  templateUrl: './orders-list.component.html',
  styleUrls: ['./orders-list.component.css']
})
export class OrdersListComponent implements OnInit {

  orders:Order[];
  errMsg:string;
  
  constructor(private orderService :OrderService) { }

  ngOnInit() {
    this.loadData();
  }
    loadData(){
      this.orders=null;
      this.errMsg=null;
  
      this.orderService.getOrder().subscribe(
        (data) =>{ this.orders=data; },
        (err) => {this.errMsg="Sorry Server not reachable!";}
      );
  
    }
    deleteOrder(orderId:number){
      if(confirm(`Are you sure you want to delete emp#${orderId}`)){
        this.orderService.deleteOrder(orderId).subscribe(
        ()=>{this.loadData();},
        (err)=>{this.errMsg=err;}
      );
      }

    }
      
}
