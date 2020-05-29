import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ButtonSharedComponent } from './button/button-shared/button-shared.component';
import { LoadingButtonComponent } from './loading/loading-button/loading-button.component';
import { ConfirmationModalComponent } from './modal/confirmation-modal/confirmation-modal.component';
import { ErrorModalComponent } from './modal/error-modal/error-modal.component';
import { WarningModalComponent } from './modal/warning-modal/warning-modal.component';
import { MembersComponent } from './members/members.component';
import { SelectComponent } from './select/select.component';
import { NzSelectModule } from 'ng-zorro-antd/select';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    ButtonSharedComponent,
    LoadingButtonComponent,
    ConfirmationModalComponent,
    ErrorModalComponent,
    WarningModalComponent,
    MembersComponent,
    SelectComponent,
  ],
  imports: [CommonModule, FormsModule,ReactiveFormsModule, NzSelectModule],
  exports: [
    ButtonSharedComponent,
    ConfirmationModalComponent,
    LoadingButtonComponent,
    ErrorModalComponent,
    WarningModalComponent,
    MembersComponent,
    SelectComponent
  ],
})
export class SharedModule {}
