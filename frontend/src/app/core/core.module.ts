import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HttpClientModule} from '@angular/common/http';

import {UserService} from './service/user.service';
import {FamiliaService} from './service/familia.service';

@NgModule({
  declarations: [],
  imports: [CommonModule, HttpClientModule],
  providers: [UserService,FamiliaService],
})
export class CoreModule {}
