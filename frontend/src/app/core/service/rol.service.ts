import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { RolPorUsuario } from '../model/rol.model';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class RolService {
  constructor(private httpClient: HttpClient) {}

  async getRol(dni: string) {
    return await this.httpClient
      .get<Array<RolPorUsuario>>(`${environment.url_api}/rolesporusuario/${dni}`, AuthService.getHeaderWithAuthorization())
      .toPromise();
  }
}
