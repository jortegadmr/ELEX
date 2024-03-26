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
  toggleMenu(section: string) {
    const menu = document.getElementById(`menu-${section}`);
    if (menu) {
      if (menu.classList.contains('show')) {
        menu.classList.remove('show');
      } else {
        menu.classList.add('show');
      }
    }
  }
}