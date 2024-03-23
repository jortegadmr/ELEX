import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TipoService {

  private http = inject(HttpClient);

  list() {
    return this.http.get('http://localhost:8008/tipo-expediente/consultar');
  }
  get(id: number) {
    return this.http.get('http://localhost:8008/tipo-expediente/consultar/${id}');
  }
}
