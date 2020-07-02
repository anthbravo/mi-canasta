import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Usuario } from 'src/app/core/model/usuario.model';
import { Tienda, TiendaUsuarioDto, TiendaLimiteDto, TiendaPut } from 'src/app/core/model/tienda.model';


@Injectable({
  providedIn: 'root',
})

export class TiendaService {
  
  constructor(private httpClient: HttpClient) {}

  async postUsuarioInTienda(idTienda: number, dni: string) {
    return await this.httpClient.post
    (`${environment.url_api}/tiendas/${idTienda}/usuario/${dni}/usuariosportienda?dni=${dni}&idTienda=${idTienda}`, null)
      .toPromise();
  }

  async listarTienda(id: any){
    return await this.httpClient.get<Tienda>(`${environment.url_api}/tiendas/${id}`)
    .toPromise();
  }

  async listarMiembros(idTienda: number){
    return await this.httpClient
      .get<Array<Usuario>>(`${environment.url_api}/tiendas/${idTienda}/usuarios`)
      .toPromise();
  }

  async getLimiteTienda(idTienda: number) {
    return await this.httpClient.get(`${environment.url_api}/tiendas/${idTienda}/limite`)
    .toPromise();
  }

  async putTienda(idTienda: number, dni: number, putTienda: TiendaPut) {
    return await this.httpClient.put(`${environment.url_api}/tiendas/${idTienda}/${dni}`, putTienda)
    .toPromise();
  }

  async cambiarRolUsuario(dni:string){
    return await this.httpClient.put(`${environment.url_api}/tiendas/${dni}/rolesPorUsuario?dni=${dni}`, null)
    .toPromise();
  }
}

