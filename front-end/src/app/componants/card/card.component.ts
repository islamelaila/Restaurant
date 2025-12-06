import {Component, OnInit} from '@angular/core';
import {CartService} from '../../../service/cart.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})

export class CardComponent implements OnInit {

  totalPrice: number = 0;
  totalNumber: number = 0;


  ngOnInit(): void {
    this.getTotal();
  }

  constructor(public cartService : CartService) {
  }

  getTotal() {
    this.cartService.totalPrice.subscribe((total) => {
      this.totalPrice = total;
    });

    this.cartService.totalNumber.subscribe((total) => {
      this.totalNumber = total;
    });
  }



}


