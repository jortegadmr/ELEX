import { Component } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(private authService: AuthService) { }

  login() {
    this.authService.login(this.username, this.password)
      .subscribe(response => {
        // Manejar la respuesta del backend (por ejemplo, almacenar el token)
      }, error => {
        // Manejar errores de autenticación
      });
  }
}
