import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import { Observable } from 'rxjs';
import {AuthService} from "../secuirty/auth.service";

@Injectable({
  providedIn: 'root'
})
export class LoginSignUpGuard implements CanActivate {
  constructor(private router: Router ,private authservice: AuthService) {
  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.authservice.isUserLoggedIn()) {
      this.router.navigateByUrl('/products');
      return false;

    }
    return true;
  }

}
