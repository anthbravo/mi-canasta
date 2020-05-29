import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeDealersRoutingModule } from './home-dealers-routing.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { HomeDealersComponent } from './components/home-dealers/home-dealers.component';


@NgModule({
  declarations: [HomeDealersComponent],
  imports: [
    CommonModule,
    HomeDealersRoutingModule,
    SharedModule
  ]
})
export class HomeDealersModule { }
