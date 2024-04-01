import { Component, OnInit, inject } from '@angular/core';
import { RouterLink } from '@angular/router';
import { TipoService } from '../services/tipo.service';


@Component({
  selector: 'app-tipo-expediente',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './tipo-expediente.component.html',
  styleUrl: './tipo-expediente.component.css'
})


export default class TipoExpedienteComponent implements OnInit {

// Método para alternar la visibilidad del menú
  toggleMenu() {
    const ocultarElements = document.querySelectorAll('.ocultar');
    ocultarElements.forEach(element => {
      element.classList.toggle('active');
    });
  }

    private contactService = inject(TipoService);

    ngOnInit(): void {
        this.tipoService = this.contactService
    }
    }

}
