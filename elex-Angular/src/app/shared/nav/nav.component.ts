import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faUser, faCode, faBars, faHome, faFolder, faTasks, faArchive, faFileAlt  } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-nav',
  standalone: true,

  /* importar los modulos que vayamos a utilizar  */
  
  imports: [
    CommonModule,
    RouterOutlet,
    FontAwesomeModule,
  ],

  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css'
})
export class NavComponent {

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