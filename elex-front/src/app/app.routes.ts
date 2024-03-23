import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '',
        loadComponent: () => import('./tipo-expediente/tipo-expediente.component')
    }
];
