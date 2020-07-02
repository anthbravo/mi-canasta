import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeUserComponent } from './components/home-user/home-user.component';
import { HomeUserEditComponent } from './components/home-user-edit/home-user-edit.component';


const routes: Routes = [
  {
    path: '',
    component: HomeUserComponent
  },
  {
    path: "edit",              
    component: HomeUserEditComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeUserRoutingModule { };