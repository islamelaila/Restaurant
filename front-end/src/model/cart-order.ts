import {Product} from './product';

export class CartOrder {
  id: number ;
  name: string ;
  imagePath: string ;
  price: number ;
  description: string ;
  quantity: number ;

  constructor( product) {
    this.id = product.id;
    this.name = product.name;
    this.imagePath = product.imagePath;
    this.price = product.price;
    this.description = product.description;
    this.quantity = 1 ;
  }
}
