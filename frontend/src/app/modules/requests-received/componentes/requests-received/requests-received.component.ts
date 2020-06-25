import { Router, ActivatedRoute } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/core/service/home.service';
import { SolicitudService } from 'src/app/core/service/solicitud.service';
import { Solicitud } from '../../../../core/model/solicitud.model';
import { Variable } from '@angular/compiler/src/render3/r3_ast';
import { UsuarioService } from '../../../../core/service/usuario.service';

@Component({
    selector: 'app-requests-received',
    templateUrl: './requests-received.component.html',
    styleUrls: ['./requests-received.component.scss'],
})
export class RequestsReceivedComponent implements OnInit {
    idFam: Number;
    switchValue = false;
    input: any;
    solicitudes = [];
    constructor(
        private homeService: HomeService,
        private solicitudService: SolicitudService,
        private usuarioService: UsuarioService,
        private route: Router,
        private _route: ActivatedRoute
    ) {}

    ngOnInit(): void {
        this.homeService.setStatus({ isLoginView: false });
        this.idFam = +this._route.snapshot.paramMap.get('idFam');
        this.getSolicitudes();
    }
    async getSolicitudes() {
        try {
            const datos = await this.solicitudService.obtenerSolicitudesPorFamilia(
                this.idFam
            );
            this.input = datos;
            this.listarSolicitudes();
            console.log(this.solicitudes);
        } catch (error) {
            console.log(error);
        }
    }
    async listarSolicitudes() {
        this.solicitudes = [];
        for (let i = 0; i < this.input.length; i++) {
            const usuario = await this.usuarioService.getUsuario(
                this.input[i].dni
            );
            this.solicitudes.push({
                title: 'Solicitudes ' + (1 + i),
                nombre: usuario.nombre,
                dni: usuario.dni,
                familiaId: this.input[i].familiaId,
                render: true,
            });
        }
        console.log('hola');
    }
}
