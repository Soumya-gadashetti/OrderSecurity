import { Component, OnInit } from '@angular/core';
import { OrderService } from '../services/order.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from '../models/order';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-order-form',
  templateUrl: './order-form.component.html',
  styleUrls: ['./order-form.component.css']
})
export class OrderFormComponent implements OnInit {

  order:Order;
   msg:string;
   isNew:boolean;
   joinDateStr :string;
  constructor(
    private orderService:OrderService,
    private actRoute:ActivatedRoute,
    private router:Router
  ) { }

  ngOnInit() {
    let orderId=this.actRoute.snapshot.params.id;
    if(orderId){
      this.isNew=false;
      this.orderService.getOrderById(orderId).subscribe(
        (data) =>{
          this.order=data;
          
        }
      );

    }else{
      this.isNew=true;
      this.order={
        "orderId":0,
        "orderDate":'',
        "orderPrice":0,
        "orderitems":{
          "orderItemId":0,
          "productId":0,
          "product":{
            "productId":0,
            "productName":'',
            "description":'',
            "price":0
          },
          "quantity":0,
          "price":0
          },
        };
       
      }
   
}
  


    save(){
      let ob:Observable<Order>;
      if(this.isNew){
        ob=this.orderService.addOrder(this.order);
      }else{
        ob=this.orderService.updateOrder(this.order);
      }
      ob.subscribe(
        (Data) =>{
          this.router.navigateByUrl("/list");
        },
        (errResponse)=> {
          this.msg=errResponse.error;
          
        }
      );
    }

}
  
