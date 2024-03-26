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
  const ocultar = document.querySelector('.ocultar');
  if (ocultar) {
    ocultar.classList.toggle('active');
  }
}
}