import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
@Component({
  selector: 'app-expedientes',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './expedientes.component.html',
  styleUrl: './expedientes.component.css'
})
export default class ExpedientesComponent {
// Método para alternar la visibilidad del menú
toggleMenu() {
  const ocultarElements = document.querySelectorAll('.ocultar');
  ocultarElements.forEach(element => {
    element.classList.toggle('active');
  });
}
}
