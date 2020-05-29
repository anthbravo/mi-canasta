import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeFamilyRoutingModule } from './home-family-routing.module';
import { HomeFamilyComponent } from './components/home-family/home-family.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { NzSwitchModule } from 'ng-zorro-antd/switch';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';


@NgModule({
  declarations: [HomeFamilyComponent],
  imports: [
    CommonModule,
    HomeFamilyRoutingModule,
    SharedModule,
    NzSwitchModule,
    ReactiveFormsModule,
    FormsModule
  ]
})
export class HomeFamilyModule { }
