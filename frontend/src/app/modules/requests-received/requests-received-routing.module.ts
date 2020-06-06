import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RequestsReceivedComponent } from './componentes/requests-received/requests-received.component';


const routes: Routes = [
  {
    path: '', component: RequestsReceivedComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RequestsReceivedRoutingModule { }
