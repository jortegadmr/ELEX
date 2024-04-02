import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './shared/header/header.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';


@Component({
  selector: 'app-root',
  standalone: true,

  /* importar los modulos que vayamos a utilizar  */

  imports: [
    RouterOutlet,
    CommonModule,
    HeaderComponent,
    DashboardComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'elex-Angular';
}
