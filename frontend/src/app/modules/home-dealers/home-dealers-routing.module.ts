import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeDealersComponent } from './components/home-dealers/home-dealers.component';


const routes: Routes = [
  {path: '', component: HomeDealersComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeDealersRoutingModule { }
