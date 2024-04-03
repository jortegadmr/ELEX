import { Injectable } from '@angular/core';
import { LoginRequest } from './loginRequest';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { throwError, Observable, catchError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  login(credentials: LoginRequest): Observable<any> {
    return this.http.get('././assets/data.json').pipe(
      // Emplear la función de manejo de errores de RxJS
      catchError(this.handleError)
    )
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // Errora de lado del lado del cliente.
      console.error('Se ha producido un error:', error.error);
    } else {
      // El backend devolvio un error
      console.error('Backend retorno el codigo de estado:', error.error);
    }
    // Definir una respuesta apropiada
    return throwError(() => new Error('Algo ha fallado; por favor, inténtelo de nuevo.'));
  }
}
