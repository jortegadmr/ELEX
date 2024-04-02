import { Routes } from '@angular/router';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { LoginComponent } from './auth/login/login.component';

export const routes: Routes = [
    /* ---Definimos las Rutas--- */
    
    { path: '', redirectTo: '/inicio', pathMatch: 'full' },
    
    
    { path: 'inicio', component: DashboardComponent },
    { path: 'login', component: LoginComponent}
];
