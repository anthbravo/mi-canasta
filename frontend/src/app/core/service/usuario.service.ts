import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Usuario, UsuarioAutenticacion, UsuarioPut, UsuarioGet } from '../model/usuario.model';
import { AuthService } from './auth.service';

@Injectable({
    providedIn: 'root',
})
export class UsuarioService {
    constructor(private httpClient: HttpClient) {}

    async getUsuario(dni: string) {
        return await this.httpClient
            .get<UsuarioGet>(
                `${environment.url_api}/usuarios/${dni}`,
                AuthService.getHeaderWithAuthorization()
            )
            .toPromise();
    }

    async putUsuario(dni: string, usuarioPut: UsuarioPut) {
        return await this.httpClient
            .put(
                `${environment.url_api}/usuarios/${dni}`, usuarioPut,
                AuthService.getHeaderWithAuthorization()
            )
            .toPromise();
    }
}
