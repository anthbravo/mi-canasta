import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RequestsSentComponent } from './components/requests-sent/requests-sent.component';


const routes: Routes = [

  {path:'', component: RequestsSentComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RequestsSentRoutingModule { }
