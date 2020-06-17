import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeUserComponent } from './components/home-user/home-user.component';
import { HomeUserRoutingModule } from './home-user.routing.module';
import { SharedModule } from 'src/app/shared/shared.module';



@NgModule({
  declarations: [HomeUserComponent],
  imports: [
    CommonModule, HomeUserRoutingModule, SharedModule
  ]
})
export class HomeUserModule { }
