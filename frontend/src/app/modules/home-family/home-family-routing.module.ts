import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeFamilyComponent } from './components/home-family/home-family.component';


const routes: Routes = [
  {
    path: '',
    component: HomeFamilyComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeFamilyRoutingModule { }
