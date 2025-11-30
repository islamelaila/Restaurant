import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseUrl = 'http://localhost:8080/product';

  constructor(private http: HttpClient) {}

  getAllProducts(pageNumber , pageSize): Observable<any> {
    return this.http.get<any>(
      this.baseUrl + '/all?pageNumber=' + pageNumber + '&pageSize=' + pageSize
    );
  }



  getProductsByCategoryId(id: number, pageNumber: number, pageSize: number): Observable<any> {
    return this.http.get<any>(
      `${this.baseUrl}/getProductsByCategoryId?categoryId=${id}&pageNumber=${pageNumber}&pageSize=${pageSize}`
    );
  }

  Search(key: string, pageNumber: number, pageSize: number): Observable<any> {
    return this.http.get<any>(
      `${this.baseUrl}/SearchProductByName?productName=${key}&pageNumber=${pageNumber}&pageSize=${pageSize}`
    );
  }

}





