import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '',
        loadComponent: () => import('./home/home.component')
    },
    {
        path: 'expedientes',
        loadComponent: () => import('./expedientes/expedientes.component')
    },
    {
        path: 'actuaciones',
        loadComponent: () => import('./actuaciones/actuaciones.component')
    },
    {
        path: 'documentos',
        loadComponent: () => import('./documentos/documentos.component')
    },
    {
        path: 'tipos-expedientes',
        loadComponent: () => import('./tipo-expediente/tipo-expediente.component')
    }
    
];
