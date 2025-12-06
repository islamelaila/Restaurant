import { Injectable } from '@angular/core';
import {CartOrder} from '../model/cart-order';
import {BehaviorSubject, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  orders: CartOrder[] = [];
  totalPrice: Subject<number> = new BehaviorSubject<number>(0);
  totalNumber: Subject<number> = new BehaviorSubject<number>(0);

  constructor() { }

  addOrder(cartOrder: CartOrder)  {
    let isExist: boolean = false;
    let existedOreder: CartOrder = undefined;

    if (this.orders.length > 0) {
      existedOreder = this.orders.find(order => order.id === cartOrder.id);
    }
    isExist = (existedOreder !== undefined);

    if (isExist){
      existedOreder.quantity ++;
    }
    else {
      this.orders.push(cartOrder);
    }
      this.caculateTotal();

    console.log(JSON.stringify(this.orders));
    console.log(this.totalNumber);
    console.log(this.totalPrice);


  }

  caculateTotal() {
    let totalNumber: number = 0;
    let totalPrice: number = 0;

    for (let order of this.orders) {
      totalNumber += order.quantity ;
      totalPrice += order.quantity * order.price ;
    }
    this.totalPrice.next(totalPrice);
    this.totalNumber.next(totalNumber);
  }

  decrementOrder(cartOrder: CartOrder) {
    cartOrder.quantity--;
    if (cartOrder.quantity === 0) {
      this.removeOrder(cartOrder);
    } else {
      this.caculateTotal();
    }
  }

  removeOrder(cartOrder: CartOrder) {
    let index = this.orders.findIndex(order => order.id === cartOrder.id);

    if (index > -1) {
      this.orders.splice(index, 1);
    }
    this.caculateTotal();
  }


}

