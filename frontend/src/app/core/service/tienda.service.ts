import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';
import { Tienda } from '../model/tienda.model';

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

}
