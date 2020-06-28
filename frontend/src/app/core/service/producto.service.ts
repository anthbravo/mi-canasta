import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';
import { ProductoGet } from '../model/producto.model';

@Injectable({
    providedIn: 'root',
})
export class ProductoService {
    constructor(private httpClient: HttpClient) {}

    async getProducto(id: number) {
        return await this.httpClient
            .get<ProductoGet>(
                `${environment.url_api}/productos/${id}`,
                AuthService.getHeaderWithAuthorization()
            )
            .toPromise();
    }
}