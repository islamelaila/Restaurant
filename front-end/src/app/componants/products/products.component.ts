import {Component, OnInit} from '@angular/core';
import {Product} from '../../../model/product';
import {ProductService} from '../../../service/product.service';
import {ActivatedRoute} from '@angular/router';
import {CartOrder} from "../../../model/cart-order";
import {CartService} from "../../../service/cart.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  page: number = 0;
  pageLength: number = 10 ;
  collectionSize: number;
  message_AR = '' ;
  message_EN = '' ;
  message_FR = '' ;


   products: Product[] = [] ;

  constructor(private productService: ProductService , private activatedRoute: ActivatedRoute , private cartService: CartService ) { }
    ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(() => this.getAllProducts()
    );
    }

  // tslint:disable-next-line:typedef
    getAllProducts() {
      let isIdExist   = this.activatedRoute.snapshot.paramMap.has('id') ;
      let isKeyExist   = this.activatedRoute.snapshot.paramMap.has('key') ;

      if (isIdExist){
        let id = this.activatedRoute.snapshot.paramMap.get('id');
        this.getProductsById(id);
      } else if (isKeyExist){
        let key = this.activatedRoute.snapshot.paramMap.get('key');
        this.search(key);
      }
      else {
        this.getProducts();
      }
    }


    getProducts(): void {
    this.productService.getAllProducts(this.page , this.pageLength).subscribe(value => {
      this.message_AR = '' ;
      this.message_EN = '' ;
      this.message_FR = '' ;
      this.products = value.products ;
      this.collectionSize = value.totalProducts;
    } , (error) => {
      console.error('Error fetching products:', error);
      this.products = [];
      }
    )
    ;
    }

  getProductsById(id): void {
    this.productService.getProductsByCategoryId(id , this.page , this.pageLength).subscribe(value => {
        this.message_AR = '' ;
        this.message_EN = '' ;
        this.message_FR = '' ;
        this.products = value.products ;
        this.collectionSize = value.totalProducts;
    } , errorResponse => {
        this.message_AR = errorResponse.error.message_ar;
        this.message_EN = errorResponse.error.message_en;
        this.message_FR = errorResponse.error.message_fr;
        this.products = [];
        this.collectionSize = 0;
      }
    );
  }

  search(key): void {
    this.productService.Search(key , this.page , this.pageLength).subscribe(value => {
      this.message_AR = '' ;
      this.message_EN = '' ;
      this.message_FR = '' ;
      this.products = value.products ;
      this.collectionSize = value.totalProducts;
    }, errorResponse => {
        this.products = [];
        this.message_AR = errorResponse.error.message_ar;
        this.message_EN = errorResponse.error.message_en;
        this.message_FR = errorResponse.error.message_fr;
      }
    );
  }

  doing(){
    this.getAllProducts();
  }

  changeSize(event: Event){
    this.pageLength = +(event.target as HTMLInputElement).value ;
    this.getAllProducts();
  }

  addProductToCart(product: Product){
    let cartOrder = new CartOrder(product);
    this.cartService.addOrder(cartOrder);
  }
}
