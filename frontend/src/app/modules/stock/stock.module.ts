import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StockRoutingModule } from './stock.routing.module';
import { StockComponent } from './components/stock/stock.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { StockProductComponent } from './components/stock-product/stock-product.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [StockComponent, StockProductComponent],
  imports: [
    CommonModule, StockRoutingModule, SharedModule, FormsModule
  ]
})
export class StockModule { }
