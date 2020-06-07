import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { SolicitudComponent } from './components/solicitud/solicitud.component';
import { HomeSolicitudRoutingModule } from './home-solicitud-routing.module';



@NgModule({
  declarations: [SolicitudComponent],
  imports: [CommonModule, HomeSolicitudRoutingModule, FormsModule, SharedModule],
})
export class HomeSolicitudModule { }
