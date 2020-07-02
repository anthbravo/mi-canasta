import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LimitComponent } from './components/limit/limit.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { LimitRoutingModule } from './limit-routing.module';
import { LimitCategoryComponent } from './components/limit-category/limit-category.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [LimitComponent, LimitCategoryComponent],
  imports: [
    CommonModule, SharedModule, LimitRoutingModule, FormsModule
  ]
})
export class LimitModule { }
