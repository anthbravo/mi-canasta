import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DealersLocationComponent } from './components/dealers-location/dealers-location.component';


const routes: Routes = [
    {path: '', component: DealersLocationComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DealersLocationRoutingModule { }
