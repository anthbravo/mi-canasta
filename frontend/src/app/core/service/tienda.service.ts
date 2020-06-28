import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';
import { StockGet, StockPut } from '../model/stock.model';

@Injectable({
    providedIn: 'root',
})
export class TiendaService {
    constructor(private httpClient: HttpClient) {}

    async getStocks(idTienda: number) {
        return await this.httpClient
            .get<Array<StockGet>>(
                `${environment.url_api}/tiendas/${idTienda}/stocks`,
                AuthService.getHeaderWithAuthorization()
            )
            .toPromise();
    }
    async putStock(idTienda: number, idProducto: number, stockPut: StockPut) {
        return await this.httpClient
            .put(
                `${environment.url_api}/tiendas/${idTienda}/productos/${idProducto}/stocks`, stockPut,
                AuthService.getHeaderWithAuthorization()
            )
            .toPromise();
    }
}
