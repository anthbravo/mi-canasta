import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { FamiliasRequest } from '../model/request/familia.model';

@Injectable({
  providedIn: 'root',
})
export class FamiliaService {
  constructor(private httpClient: HttpClient) {}

  async crearFamilia(familiaRequest: FamiliasRequest) {
    return await this.httpClient
      .post(`${environment.url_api}/familias`, familiaRequest)
      .toPromise();
  }
}
