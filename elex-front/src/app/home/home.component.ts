import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
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
}