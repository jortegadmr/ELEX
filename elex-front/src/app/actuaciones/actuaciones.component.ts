import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-actuaciones',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './actuaciones.component.html',
  styleUrl: './actuaciones.component.css'
})
export default class ActuacionesComponent {
// Método para alternar la visibilidad del menú
toggleMenu() {
  const ocultarElements = document.querySelectorAll('.ocultar');
  ocultarElements.forEach(element => {
    element.classList.toggle('active');
  });
}
}
