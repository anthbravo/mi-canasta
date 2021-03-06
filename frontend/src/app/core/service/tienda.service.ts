import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Usuario } from 'src/app/core/model/usuario.model';
import { Tienda, TiendaUsuarioDto, TiendaPut } from 'src/app/core/model/tienda.model';
import { AuthService } from './auth.service';
import { Stock, StockGet, StockPut } from '../model/stock.model';

@Injectable({
  providedIn: 'root',
})

export class TiendaService {

  constructor(private httpClient: HttpClient) {}

  async postUsuarioInTienda(idTienda: number, dni: string) {
    return await this.httpClient.post
    (`${environment.url_api}/tiendas/${idTienda}/usuario/${dni}/usuariosportienda?dni=${dni}&idTienda=${idTienda}`, null, AuthService.getHeaderWithAuthorization())
      .toPromise();
  }

  async listarTiendas(){
      return await this.httpClient.get<Tienda[]>(
          `${environment.url_api}/tiendas`,
          AuthService.getHeaderWithAuthorization()
      ).toPromise();
  }

  async listarTienda(id: any){
    return await this.httpClient.get<Tienda>(`${environment.url_api}/tiendas/${id}`, AuthService.getHeaderWithAuthorization())
    .toPromise();
  }

  async listarMiembros(idTienda: number){
    return await this.httpClient
      .get<Array<Usuario>>(`${environment.url_api}/tiendas/${idTienda}/usuarios`, AuthService.getHeaderWithAuthorization())
      .toPromise();
  }

  async listarStock(tiendaId:number){
      return await this.httpClient.get<Stock[]>(`${environment.url_api}/tiendas/${tiendaId}/stocks`, AuthService.getHeaderWithAuthorization())
      .toPromise()
  }

  async getLimiteTienda(idTienda: number) {
    return await this.httpClient.get(`${environment.url_api}/tiendas/${idTienda}/limite`)
    .toPromise();
  }

  async putTienda(idTienda: number, dni: number, putTienda: TiendaPut) {
    return await this.httpClient.put(`${environment.url_api}/tiendas/${idTienda}/${dni}`, putTienda, AuthService.getHeaderWithAuthorization() )
    .toPromise();
  }

  async cambiarRolUsuario(dni:string){
    return await this.httpClient.put(`${environment.url_api}/tiendas/${dni}/rolesPorUsuario?dni=${dni}`, null, AuthService.getHeaderWithAuthorization() )
    .toPromise();
  }

  async getStocks(idTienda: number) {
    return await this.httpClient.get<Array<StockGet>>
    (`${environment.url_api}/tiendas/${idTienda}/stocks`, AuthService.getHeaderWithAuthorization())
      .toPromise();
  }

  async putStock(idTienda: number, idProducto: number, stockPut: StockPut) {
    return await this.httpClient.put
    (`${environment.url_api}/tiendas/${idTienda}/productos/${idProducto}/stocks`, stockPut, AuthService.getHeaderWithAuthorization())
      .toPromise();
  }
}
