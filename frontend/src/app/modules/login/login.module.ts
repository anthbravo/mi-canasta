import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

import {LoginRoutingModule} from './login-routing.module';
import {LoginComponent} from './components/login/login.component';
import {SharedModule} from '../../../app/shared/shared.module';

@NgModule({
  declarations: [LoginComponent],
  imports: [CommonModule, LoginRoutingModule, FormsModule, SharedModule],

})
export class LoginModule {}
