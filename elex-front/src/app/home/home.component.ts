import { Component, OnInit, NgModule, ViewChild, ElementRef } from '@angular/core';
import { RouterLink, Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, FormControl, NgForm } from '@angular/forms';
import { LoginService } from '../services/auth/login.service';
import { LoginRequest } from '../services/auth/loginRequest';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterLink, CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'

})
export default class HomeComponent {
  router: any;
username: any;
password: any;
  

// Método para alternar la visibilidad del menú

  toggleMenu() {
    const ocultarElements = document.querySelectorAll('.ocultar');
    ocultarElements.forEach(element => {
      element.classList.toggle('active');
    });
  }

  // Visibilidad del LOGIN

  userLoginOn: boolean = true;


  // LOGIN formulario

  loginForm = this.formBuilder.group({
    username: ['', [Validators.required]],
    password: ['', [Validators.required]],
  })
  constructor(
    private formBuilder: FormBuilder,
    private loginService: LoginService,) { }

  ngOnInit(): void {
  }

  
  login() {
    if (this.loginForm.valid) {
      
        /* this.loginService.login(this.loginForm.value as LoginRequest);
        this.loginForm.reset(); */
        /*  this.userLoginOn = true; */

        const username = this.loginForm.get('username')?.value;
        const password = this.loginForm.get('password')?.value;

        // Aquí puedes usar los valores del nombre de usuario y la contraseña
        console.log('Nombre de usuario:', username);
        console.log('Contraseña:', password);

        this.router.navigateByUrl('/expedientes');
    }
    else {
      alert("Los campos no pueden estar vacíos");
    }
  }
}
