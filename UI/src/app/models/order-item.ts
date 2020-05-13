import { Product } from './product';
import { Order } from './order';

export class OrderItem {
    public orderItemId:number;
    public productId:number;
    public product:Product;
    public quantity:number;
    public price:number;
    
}
