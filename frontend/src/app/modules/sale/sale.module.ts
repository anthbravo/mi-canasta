import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SaleRoutingModule } from './sale-routing.module';
import { SalePageComponent } from './componentes/sale-page/sale-page.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { NzSliderModule } from 'ng-zorro-antd/slider';
import { NzInputModule} from 'ng-zorro-antd/input';
import { NzInputNumberModule} from 'ng-zorro-antd/input-number';


@NgModule({
  declarations: [SalePageComponent],
  imports: [
    CommonModule,
    SaleRoutingModule,
    NzSliderModule,
    NzInputModule,
    NzInputNumberModule,
    FormsModule,

  ]
})
export class SaleModule { }
