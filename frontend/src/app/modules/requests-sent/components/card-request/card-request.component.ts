import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { SolicitudService } from '../../../../core/service/solicitud.service';

@Component({
    selector: 'app-card-request',
    templateUrl: './card-request.component.html',
    styleUrls: ['./card-request.component.scss'],
})
export class CardRequestComponent implements OnInit {
    @Input()
    request: any;

    @Output()
    eventRefresh = new EventEmitter<any>();

    constructor(private solicitudService: SolicitudService) {}

    ngOnInit(): void {}
    async cancelarSolicitud() {
        try {
            const value = await this.solicitudService.denegarSolicitud(
                this.request.dni
            );
            console.log(value);
            this.eventRefresh.emit();
        } catch (error) {
            console.log(error);
        }
    }
}
