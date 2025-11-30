import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../../model/product";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  baseUrl = 'http://localhost:8080/auth';

  constructor(private http: HttpClient) {}


  signUp(username , password): Observable<any> {
    return this.http.post<any>(this.baseUrl + '/signup', {
      username , password
    }).pipe(
      map(response => response)
    );
  }

  login(username , password): Observable<any> {
    return this.http.post<any>(this.baseUrl + '/login', {
      username , password
    }).pipe(
      map(response => response)
    );
  }

  logout(){
    sessionStorage.removeItem('token');
  }

  isUserLoggedIn(): boolean {
    return !!sessionStorage.getItem('token');
  }

}
