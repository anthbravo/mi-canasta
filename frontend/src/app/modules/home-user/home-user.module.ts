import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeUserComponent } from './components/home-user/home-user.component';
import { HomeUserRoutingModule } from './home-user.routing.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { HomeUserEditComponent } from './components/home-user-edit/home-user-edit.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [HomeUserComponent, HomeUserEditComponent],
  imports: [
    CommonModule, HomeUserRoutingModule, SharedModule, FormsModule
  ]
})
export class HomeUserModule { }
