import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RequestsReceivedRoutingModule } from './requests-received-routing.module';
import { RequestsReceivedComponent } from './componentes/requests-received/requests-received.component';
import { RequestReceivedCardComponent } from './componentes/request-received-card/request-received-card.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { NzSwitchModule } from 'ng-zorro-antd/switch';


@NgModule({
  declarations: [RequestsReceivedComponent, RequestReceivedCardComponent],
  imports: [
    CommonModule,
    RequestsReceivedRoutingModule,
    ReactiveFormsModule,
    NzSwitchModule,
    FormsModule
  ]
})
export class RequestsReceivedModule { }
