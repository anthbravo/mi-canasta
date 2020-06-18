import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BuyRoutingModule } from './buy-routing.module';
import { BuyPageComponent } from './componentes/buy-page/buy-page.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { NzSliderModule } from 'ng-zorro-antd/slider';
import { NzInputModule} from 'ng-zorro-antd/input';
import { NzInputNumberModule} from 'ng-zorro-antd/input-number';

@NgModule({
  declarations: [BuyPageComponent],
  imports: [
    CommonModule,
    BuyRoutingModule,
    NzSliderModule,
    NzInputModule,
    NzInputNumberModule,
    FormsModule,

  ]
})
export class buyModule { }
