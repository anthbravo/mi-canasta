import { environment } from '../../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario, UsuarioAutenticacion } from '../model/usuario.model';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private usuarioAutenticacion: UsuarioAutenticacion;

  constructor(private httpClient: HttpClient) {}

  async authentication(usuario: Usuario) {
    return await this.httpClient
      .post<UsuarioAutenticacion>(`${environment.url_api}/usuarios`, usuario)
      .toPromise();
  }

  getUsuarioAutenticacion() {
    return this.usuarioAutenticacion;
  }

  loadUsuarioAutenticacion() {
    this.usuarioAutenticacion = JSON.parse(localStorage.getItem('usuario'));
  }

  saveUsuarioAutenticacion(usuarioAutenticacion: UsuarioAutenticacion) {
    this.usuarioAutenticacion = usuarioAutenticacion;
    localStorage.setItem('usuario', JSON.stringify(usuarioAutenticacion));
  }
}
