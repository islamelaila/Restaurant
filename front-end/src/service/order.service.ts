import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class OrderService {


  baseUrl = 'http://localhost:8080/orders';

  constructor(private http: HttpClient) {}


  createOrder(orderVms): Observable<any> {
    return this.http.post<any>(this.baseUrl + '/create', {
      orderVms
    }).pipe(
      map(response => response)
    );
  }
}
