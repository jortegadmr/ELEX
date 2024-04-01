import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
@Component({
  selector: 'app-tipo-expediente',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './tipo-expediente.component.html',
  styleUrl: './tipo-expediente.component.css'
})
export default class TipoExpedienteComponent {
// Método para alternar la visibilidad del menú
toggleMenu() {
  const ocultarElements = document.querySelectorAll('.ocultar');
  ocultarElements.forEach(element => {
    element.classList.toggle('active');
  });
}
}
