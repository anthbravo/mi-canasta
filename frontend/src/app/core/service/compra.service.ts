import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';
import { CompraGet } from '../model/compra.model';

@Injectable({
  providedIn: 'root',
})

export class CompraService {
  
    constructor(private httpClient: HttpClient) {}
    
    async getCompras(idFamilia: number, fechaInicio: Date, fechaFin: Date, dni: string){
    return await this.httpClient
    .get<Array<CompraGet>>(`${environment.url_api}/compras?dni=${dni}&fechaFin=${fechaFin}&fechaInicio=${fechaInicio}&idFamilia=${idFamilia}`, AuthService.getHeaderWithAuthorization()).toPromise()
  }

}