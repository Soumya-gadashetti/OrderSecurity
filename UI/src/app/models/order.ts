import { OrderItem } from './order-item';

export class Order {
    public orderId:number;
    public orderDate:String;
    public orderPrice:number;
     public orderitems:OrderItem;
}
