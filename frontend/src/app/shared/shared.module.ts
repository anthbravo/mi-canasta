import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ButtonSharedComponent } from './button/button-shared/button-shared.component';
import { LoadingButtonComponent } from './loading/loading-button/loading-button.component';
import { ConfirmationModalComponent } from './modal/confirmation-modal/confirmation-modal.component';
import { ErrorModalComponent } from './modal/error-modal/error-modal.component';
import { WarningModalComponent } from './modal/warning-modal/warning-modal.component';

@NgModule({
  declarations: [
    ButtonSharedComponent,
    LoadingButtonComponent,
    ConfirmationModalComponent,
    ErrorModalComponent,
    WarningModalComponent,
  ],
  imports: [CommonModule],
  exports: [
    ButtonSharedComponent,
    ConfirmationModalComponent,
    LoadingButtonComponent,
    ErrorModalComponent,
    WarningModalComponent
  ],
})
export class SharedModule {}
