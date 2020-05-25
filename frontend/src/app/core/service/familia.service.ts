import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Familia, FamiliaCreate } from '../model/familia.model';

@Injectable({
  providedIn: 'root',
})
export class FamiliaService {
  constructor(private httpClient: HttpClient) {}

  async crearFamilia(familia: FamiliaCreate) {
    return await this.httpClient
      .post(`${environment.url_api}/familias`, familia)
      .toPromise();
  }
}
