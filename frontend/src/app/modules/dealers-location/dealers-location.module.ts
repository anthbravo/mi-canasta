import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DealersLocationRoutingModule } from './dealers-location-routing.module';
import { DealersLocationComponent } from './components/dealers-location/dealers-location.component';
import { AgmCoreModule } from '@agm/core';
import { NzSelectModule } from 'ng-zorro-antd/select';
import { FormsModule } from '@angular/forms';

@NgModule({
    declarations: [DealersLocationComponent],
    imports: [
        CommonModule,
        NzSelectModule,
        DealersLocationRoutingModule,
        AgmCoreModule,
        FormsModule
    ],
})
export class DealersLocationModule {}
