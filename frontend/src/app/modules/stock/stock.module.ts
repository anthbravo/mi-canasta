import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StockComponent } from './components/stock/stock.component';
import { StockProductComponent } from './components/stock-product/stock-product.component';
import { StockRoutingModule } from './stock.routing.module';
import { FormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  declarations: [StockComponent, StockProductComponent],
  imports: [
    CommonModule, SharedModule, FormsModule, StockRoutingModule
  ]
})
export class StockModule { }
