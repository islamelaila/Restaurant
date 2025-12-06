import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../../service/secuirty/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  message_AR = '' ;
  message_EN = '' ;
  message_FR ='' ;

  constructor(private authservice : AuthService , private router: Router) { }

  ngOnInit(): void {
  }

  login(username, password) {
    if (!this.validateInput(username, password)) {
      setTimeout(() => {
        this.message_AR = '';
        this.message_EN = '';
        this.message_FR = '';
      }, 3000);
      return;
    }

    this.authservice.login(username, password).subscribe(
      response => {
        sessionStorage.setItem('token', response.token);
        this.router.navigateByUrl('/products');
      },
      errorResponse => {
        this.message_AR = errorResponse.error.message_ar;
        this.message_EN = errorResponse.error.message_en;
        this.message_FR = errorResponse.error.message_fr;

        setTimeout(() => {
          this.message_AR = '';
          this.message_EN = '';
          this.message_FR = '';
        }, 3000);
      }
    );
  }


  validateInput(username, password) {
    if (!username) {
      this.message_AR = 'من فضلك أدخل اسم المستخدم';
      this.message_EN = 'Please enter a username';
      this.message_FR = "Veuillez entrer un nom d'utilisateur";
      return false;
    }

    if (!password) {
      this.message_AR = 'من فضلك أدخل كلمة المرور';
      this.message_EN = 'Please enter a password';
      this.message_FR = 'Veuillez entrer un mot de passe';
      return false;
    }
    return true;
  }

}




