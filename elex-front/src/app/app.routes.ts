import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '',
        loadComponent: () => import('./home/home.component')
    },
    {
        path: 'expedientes',
        loadComponent: () => import('./tipo-expediente/tipo-expediente.component')
    }
    
];
