import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';
import { CategoriaGet } from '../model/categoria.model';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {
  constructor(private httpClient: HttpClient) {}

  async getCategoria(id: number) {
    return await this.httpClient
      .get<CategoriaGet>(`${environment.url_api}/categorias/${id}`, AuthService.getHeaderWithAuthorization())
      .toPromise();
  }

  async listarDetalleProducto(id:number):Promise<any> {
      return await this.httpClient
          .get(`${environment.url_api}/categorias/${id}`,AuthService.getHeaderWithAuthorization())
          .toPromise();
  }
}
