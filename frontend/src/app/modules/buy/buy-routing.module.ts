import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BuyPageComponent } from './componentes/buy-page/buy-page.component';

const routes: Routes = [
  {path: '', component: BuyPageComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BuyRoutingModule { }
