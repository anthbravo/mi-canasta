import { environment } from '../../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario, UsuarioAutenticacion } from '../model/usuario.model';
import { Router } from '@angular/router';

@Injectable({
    providedIn: 'root',
})
export class AuthService {
    constructor(private httpClient: HttpClient, private router: Router) {}
    private usuarioAutenticacion: UsuarioAutenticacion;

    static getHeaderWithAuthorization() {
        return {
            headers: new HttpHeaders()
                .set('Content-Type', 'application/json')
                .set(
                    'Authorization',
                    'Bearer ' +
                        JSON.parse(
                            sessionStorage.getItem(environment.TOKEN_NAME)
                        ).access_token
                ),
        };
    }

    async authentication(usuario: Usuario):Promise<UsuarioAutenticacion> {
        return await this.httpClient
            .post<UsuarioAutenticacion>(
                `${environment.url_api}/usuarios`,
                usuario
            )
            .toPromise();
    }

    getUsuarioAutenticacion() {
        return this.usuarioAutenticacion;
    }

    loadUsuarioAutenticacion() {
        this.usuarioAutenticacion = JSON.parse(
            sessionStorage.getItem('usuario')
        );
    }

    saveUsuarioAutenticacion(usuarioAutenticacion: UsuarioAutenticacion) {
        this.usuarioAutenticacion = usuarioAutenticacion;
        sessionStorage.setItem('usuario', JSON.stringify(usuarioAutenticacion));
    }

    async generateToken(usuario: Usuario) {
        const body = `grant_type=password&username=${usuario.dni}&password=${usuario.contrasena}`;

        return await this.httpClient
            .post(`https://mi-canasta.herokuapp.com/oauth/token`, body, {
                headers: new HttpHeaders()
                    .set(
                        'Content-Type',
                        'application/x-www-form-urlencoded; charset=UTF-8'
                    )
                    .set(
                        'Authorization',
                        'Basic ' +
                            btoa(
                                environment.TOKEN_AUTH_USERNAME +
                                    ':' +
                                    environment.TOKEN_AUTH_PASSWORD
                            )
                    ),
            })
            .toPromise();
    }

    isLogged() {
        let token = sessionStorage.getItem(environment.TOKEN_NAME);
        return token != null;
    }

    signOut() {
        let access_token = JSON.parse(
            sessionStorage.getItem(environment.TOKEN_NAME)
        ).access_token;
        this.httpClient
            .get(`${environment.url_api}/tokens/cancel/${access_token}`)
            .subscribe(() => {
                sessionStorage.clear();
                this.router.navigate(['login']);
            });
    }
}
