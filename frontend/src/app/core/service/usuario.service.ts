import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Usuario, UsuarioAutenticacion } from '../model/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private httpClient: HttpClient) { }

  async getUsuario(dni:string){
    return await this.httpClient.get<UsuarioAutenticacion>(`${environment.url_api}/usuarios/${dni}`)
    .toPromise();
  }
}
