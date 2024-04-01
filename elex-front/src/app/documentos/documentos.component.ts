import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
@Component({
  selector: 'app-documentos',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './documentos.component.html',
  styleUrl: './documentos.component.css'
})
export default class DocumentosComponent {
// Método para alternar la visibilidad del menú
toggleMenu() {
  const ocultarElements = document.querySelectorAll('.ocultar');
  ocultarElements.forEach(element => {
    element.classList.toggle('active');
  });
}
}
