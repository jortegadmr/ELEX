import { Component, OnInit, NgModule } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterLink, CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export default class HomeComponent {

// Método para alternar la visibilidad del menú

  toggleMenu() {
    const ocultarElements = document.querySelectorAll('.ocultar');
    ocultarElements.forEach(element => {
      element.classList.toggle('active');
    });
  }

  // Visibilidad del LOGIN

  userLoginOn: boolean = false;


  // LOGIN formulario

  loginForm = this.formBuilder.group({
    username: ['soltel', [Validators.required]],
    password: ['admin', [Validators.required]],
  })
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
  }

  login() {
    if (this.loginForm.valid) {
      
      console.log("Lllamar al servicio de login");
      this.loginForm.reset();
     /*  this.userLoginOn = true; */
    }
    else {
      alert("Los campos no pueden estar vacíos");
    }
  }
}
