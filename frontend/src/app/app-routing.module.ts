import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout/components/layout/layout.component';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';
import { HomeFamilyComponent } from './modules/home-family/components/home-family/home-family.component';

const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      {
        path: '',
        redirectTo: '/login',
        pathMatch: 'full',
      },
      {
        path: 'login',
        loadChildren: () =>
          import('./modules/login/login.module').then((m) => m.LoginModule),
      },
      {
        path: 'home',
        loadChildren: () =>
          import('./modules/home/home.module').then((m) => m.HomeModule),

      },
      {
        path: 'home/family',
        loadChildren: ()=>
          import("./modules/home-family/home-family.module").then((m)=>m.HomeFamilyModule)
      },
      {
        path: 'home/dealers',
        loadChildren: ()=>
          import("./modules/home-dealers/home-dealers.module").then((m)=>m.HomeDealersModule)
      },
      {
        path: 'home/solicitudes',
        loadChildren: ()=>
          import("./modules/home-solicitud/home-solicitud.module").then((m)=>m.HomeSolicitudModule)
      },
        path: 'home/request-sent',
        loadChildren: ()=>
          import("./modules/requests-sent/requests-sent.module").then((m)=>m.RequestsSentModule)
      },
      {
        path:'home/request-received',
        loadChildren: ()=>
          import("./modules/requests-received/requests-received.module").then( m=>m.RequestsReceivedModule)

      }
    ],
  },
  {
    path: '**',
    component: PageNotFoundComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
