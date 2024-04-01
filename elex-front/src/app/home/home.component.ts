import { Component, OnInit, NgModule } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup } from '@angular/forms';

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
    username: ['soltel'],
    password: ['admin'],
  })
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
  }
  }
