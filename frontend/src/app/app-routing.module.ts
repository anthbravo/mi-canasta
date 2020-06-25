import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout/components/layout/layout.component';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';
import { HomeFamilyComponent } from './modules/home-family/components/home-family/home-family.component';
import { HomeUserModule } from './modules/home-user/home-user.module';

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
        path: 'home/family/:id',
        loadChildren: ()=>
          import('./modules/home-family/home-family.module').then((m)=>m.HomeFamilyModule)
      },
      {
        path: 'home/dealers/:id',
        loadChildren: ()=>
          import('./modules/home-dealers/home-dealers.module').then((m)=>m.HomeDealersModule)
      },
      {
        path: 'home/solicitudes',
        loadChildren: ()=>
          import('./modules/home-solicitud/home-solicitud.module').then((m)=>m.HomeSolicitudModule)
      },
      {
        path: 'home/request-sent',
        loadChildren: ()=>
          import('./modules/requests-sent/requests-sent.module').then((m)=>m.RequestsSentModule)
      },
      {
        path: 'home/request-received',
        loadChildren: () =>
          import('./modules/requests-received/requests-received.module').then( m=>m.RequestsReceivedModule)

      },
      {
        path: 'home/sale',
        loadChildren : ()=>
          import('./modules/sale/sale.module').then( m=> m.SaleModule)
      },
      {
        path: 'home/buy',
        loadChildren : ()=>
          import('./modules/buy/buy.module').then( (m)=> m.buyModule)
      },
      {
        path: 'home/user',
        loadChildren: () =>
            import('./modules/home-user/home-user.module').then(
                (m) => m.HomeUserModule
            ),
      },

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
