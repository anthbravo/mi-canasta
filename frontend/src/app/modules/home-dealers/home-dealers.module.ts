import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeDealersRoutingModule } from './home-dealers-routing.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { HomeDealersComponent } from './components/home-dealers/home-dealers.component';
import { FormsModule } from '@angular/forms';
import { CoreModule } from 'src/app/core/core.module';


@NgModule({
  declarations: [HomeDealersComponent],
  imports: [
    CommonModule,
    HomeDealersRoutingModule,
    FormsModule,
    SharedModule,
    CoreModule
  ],
})
export class HomeDealersModule { }
