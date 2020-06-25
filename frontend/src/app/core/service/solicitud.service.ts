import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Solicitud, SolicitudResponse } from '../model/solicitud.model';
import { AuthService } from './auth.service';

@Injectable({
    providedIn: 'root',
})
export class SolicitudService {
    constructor(private httpClient: HttpClient) {}

    async crearSolicitud(solicitud: Solicitud) {
        return await this.httpClient
            .post(
                `${environment.url_api}/solicitudes`,
                solicitud,
                AuthService.getHeaderWithAuthorization()
            )
            .toPromise();
    }
    //deniega la solicitud entrante
    async denegarSolicitud(dni?: string) {
        return await this.httpClient
            .delete(
                `${environment.url_api}/solicitudes/${dni}`,
                AuthService.getHeaderWithAuthorization()
            )
            .toPromise();
    }
    async obtenerSolicitudesPorFamilia(familiaId: Number) {
        return await this.httpClient
            .get(
                `${environment.url_api}/solicitudes?familiaId=${familiaId}`,
                AuthService.getHeaderWithAuthorization()
            )
            .toPromise();
    }

    async aceptarSolicitud(solicitud: SolicitudResponse) {
        return await this.httpClient
            .post(
                `${environment.url_api}/usuariosporfamilia`,
                solicitud,
                AuthService.getHeaderWithAuthorization()
            )
            .toPromise();
    }
}
