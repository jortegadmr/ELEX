import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '',
        loadComponent: () => import('./home/home.component'),
        pathMatch: 'full'
        
    },
    {
        path: 'expedientes',
        loadComponent: () => import('./expedientes/expedientes.component'),
        pathMatch: 'full'
    },
    {
        path: 'actuaciones',
        loadComponent: () => import('./actuaciones/actuaciones.component'),
        pathMatch: 'full'
    },
    {
        path: 'documentos',
        loadComponent: () => import('./documentos/documentos.component'),
        pathMatch: 'full'
    },
    {
        path: 'tipos-expedientes',
        loadComponent: () => import('./tipo-expediente/tipo-expediente.component'),
        pathMatch: 'full'
    },
   
];
