import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: true,

  /* importar los modulos que vayamos a utilizar  */

  imports: [
    CommonModule,
    RouterOutlet
  ],

  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

}
