import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faUser, faCode, faBars, faHome, faFolder, faTasks, faArchive, faFileAlt  } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-header',
  standalone: true,

  /* importar los modulos que vayamos a utilizar  */

  imports: [
    CommonModule,
    RouterOutlet,
    FontAwesomeModule
  ],

  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

/* ICONOS FONTAWESOME  */
  faUser = faUser;
  faCode = faCode;
  faBars = faBars;
  faHome = faHome;
  faFolder = faFolder;
  faTasks = faTasks;
  faArchive = faArchive;
  faFileAlt = faFileAlt;
/* -----------------------  */

}
