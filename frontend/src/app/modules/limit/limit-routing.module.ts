import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LimitComponent } from './components/limit/limit.component';


const routes: Routes = [
  {
    path: '',
    component: LimitComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LimitRoutingModule { };