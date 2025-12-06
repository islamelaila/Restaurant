import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-order-res',
  templateUrl: './order-res.component.html',
  styleUrls: ['./order-res.component.css']
})
export class OrderResComponent implements OnInit {

  code: string;
  totalPrice: number;
  totalNumber: number;

  constructor(private activatedRoute: ActivatedRoute , private router: Router) { }

  ngOnInit(): void {
    let isCodeExist = this.activatedRoute.snapshot.paramMap.has('code');
    let isSizeExist = this.activatedRoute.snapshot.paramMap.has('size');
    let isPriceExist = this.activatedRoute.snapshot.paramMap.has('price');

    if (!isCodeExist && !isSizeExist && !isPriceExist) {
      this.router.navigateByUrl('/products');
    }
    this.code = this.activatedRoute.snapshot.paramMap.get('code');
    this.totalNumber = Number(this.activatedRoute.snapshot.paramMap.get('size'));
    this.totalPrice = Number(this.activatedRoute.snapshot.paramMap.get('price'));

  }

}
