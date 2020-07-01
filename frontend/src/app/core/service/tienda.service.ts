import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Usuario } from 'src/app/core/model/usuario.model';
import { Tienda, TiendaUsuarioDto } from 'src/app/core/model/tienda.model';
import { AuthService } from './auth.service';
import { StockGet, StockPut } from '../model/stock.model';

@Injectable({
  providedIn: 'root'
})
export class TiendaService {

    constructor(private httpClient: HttpClient) {}

    async listarTiendas(): Promise<Tienda[]> {
        return await this.httpClient
            .get<Tienda[]>(
                `${environment.url_api}/tiendas`,
                AuthService.getHeaderWithAuthorization()
            )
            .toPromise();
    }

    async detalleTienda(id:number){
        return await this.httpClient
            .get(
                `${environment.url_api}/tiendas/${id}`,
                AuthService.getHeaderWithAuthorization()
            ).toPromise();
    }

    async listarStock(id:number): Promise<any>{
        return await this.httpClient
            .get(
                `${environment.url_api}/tiendas/${id}/stocks`,
                AuthService.getHeaderWithAuthorization()
            )
    }
  
  async postUsuarioInTienda(idTienda: number, dni: string) {
    return await this.httpClient.post
    (`${environment.url_api}/tiendas/${idTienda}/usuario/${dni}/usuariosportienda?dni=${dni}&idTienda=${idTienda}`, null, AuthService.getHeaderWithAuthorization())
      .toPromise();
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
