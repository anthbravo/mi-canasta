import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RequestsSentRoutingModule } from './requests-sent-routing.module';
import { RequestsSentComponent } from './components/requests-sent/requests-sent.component';
import { CardRequestComponent } from './components/card-request/card-request.component';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  declarations: [RequestsSentComponent, CardRequestComponent],
  imports: [
    CommonModule,
    RequestsSentRoutingModule,
    SharedModule
  ]
})
export class RequestsSentModule { }
