import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SalePageComponent } from './componentes/sale-page/sale-page.component';


const routes: Routes = [
  {path: '', component: SalePageComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SaleRoutingModule { }
