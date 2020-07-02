import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/core/service/home.service';
import { SolicitudService } from '../../../../core/service/solicitud.service';
import { AuthService } from '../../../../core/service/auth.service';
@Component({
    selector: 'app-requests-sent',
    templateUrl: './requests-sent.component.html',
    styleUrls: ['./requests-sent.component.scss'],
})
export class RequestsSentComponent implements OnInit {
    mock = [{ familyName: 'Familia82BDH' }];
    nombreFam = [];
    usuario: any;
    datoUsuario: any;
    constructor(
        private homeService: HomeService,
        private solicitudService: SolicitudService,
        private authService: AuthService
    ) {}

    ngOnInit(): void {
        this.homeService.setStatus({ isLoginView: false });
        this.usuario = this.authService.getUsuarioAutenticacion();
        this.getSolicitud();
    }
    async getSolicitud() {
        try {
            this.nombreFam = [];
            console.log(this.usuario);
            let dni = this.usuario.usuario.dni;
            console.log(dni);
            const input = await this.solicitudService.obtenerSolicitudes(dni);
            this.datoUsuario = input;
            console.log(input);
            this.nombreFam = [
                {
                    familyName: this.datoUsuario.nombreFamilia,
                    dni: dni,
                },
            ];
        } catch (error) {
            console.log(error);
        }
    }
}
