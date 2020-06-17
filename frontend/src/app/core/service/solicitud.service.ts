import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Solicitud } from '../model/solicitud.model';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root',
})
export class SolicitudService {
    constructor(private httpClient: HttpClient) {}
  
    async crearSolicitud(solicitud: Solicitud) {
      return await this.httpClient
        .post(`${environment.url_api}/solicitudes`, solicitud, AuthService.getHeaderWithAuthorization())
        .toPromise();
    }
}