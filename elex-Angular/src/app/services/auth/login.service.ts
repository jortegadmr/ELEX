import { Injectable } from '@angular/core';
import { LoginRequest } from './loginRequest';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { throwError, Observable, catchError, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  currentUserLoginOn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  constructor(private http: HttpClient) { }

  login(credentials: LoginRequest): Observable<any> {
    return this.http.post<any>('http://localhost:8008/login', credentials).pipe(
      // Emplear la función de manejo de errores de RxJS
      catchError(this.handleError)
    )
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // Error de lado del lado del cliente.
      console.error('Se ha producido un error:', error.error);
    } else {
      // El backend devolvio un error
      console.error('Backend retorno el codigo de estado:', error.error);
    }
    // Definir una respuesta apropiada
    return throwError(() => new Error('Algo ha fallado; por favor, inténtelo de nuevo.'));
  }
}
