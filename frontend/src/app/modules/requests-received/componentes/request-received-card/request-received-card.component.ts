import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { SolicitudService } from 'src/app/core/service/solicitud.service';
import { SolicitudResponse } from 'src/app/core/model/solicitud.model';
@Component({
    selector: 'app-request-received-card',
    templateUrl: './request-received-card.component.html',
    styleUrls: ['./request-received-card.component.scss'],
})
export class RequestReceivedCardComponent implements OnInit {
    @Input()
    request: any;
    solicitudRequest: SolicitudResponse;

    @Output()
    eventRefresh = new EventEmitter<any>();

    constructor(private solicitudService: SolicitudService) {}

    ngOnInit(): void {}

    async aceptedSolicitude() {
        this.solicitudRequest = {
            dni: this.request.dni,
            familiaId: this.request.familiaId,
        };
        try {
            const res = await this.solicitudService.aceptarSolicitud(
                this.solicitudRequest
            );
            console.log(res);
            this.eventRefresh.emit();
        } catch (error) {
            console.log(error);
        }
    }
    async deniedSolicitude() {
        try {
            await this.solicitudService.denegarSolicitud(this.request.dni);
            this.eventRefresh.emit();
        } catch (error) {
            console.log(error);
        }
    }
}
