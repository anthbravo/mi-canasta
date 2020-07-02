import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout/components/layout/layout.component';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';
import { GuardService } from './core/service/guard.service';
import { HomeUserModule } from './modules/home-user/home-user.module';
import { LayoutFamilyComponent } from './layout/components/layout-family/layout-family.component';
import { LayoutDealerComponent } from './layout/components/layout-dealer/layout-dealer.component';

const routes: Routes = [
    {
        path: 'family',
        component: LayoutFamilyComponent,
        children: [
            // {
            //     path: 'map',
            //     canActivate: [GuardService],
            //     loadChildren: () =>
            //         import(
            //             './modules/dealers-location/dealers-location.module'
            //         ).then((m) => m.DealersLocationModule),
            // },
            {
                path: 'members/:id',
                canActivate: [GuardService],
                loadChildren: () =>
                    import('./modules/home-family/home-family.module').then(
                        (m) => m.HomeFamilyModule
                    ),
            },
            {
                path: 'limit',
                canActivate: [GuardService],
                loadChildren: () =>
                    import('./modules/limit/limit.module').then(
                        (m) => m.LimitModule
                    ),
            },
            {
                path: 'account',
                canActivate: [GuardService],
                loadChildren: () =>
                    import('./modules/home-user/home-user.module').then(
                        (m) => m.HomeUserModule
                    ),
            },
        ],
    },
    {
        path: 'dealer',
        component: LayoutDealerComponent,
        children: [
            // {
            //     path: 'map',
            //     canActivate: [GuardService],
            //     loadChildren: () =>
            //         import(
            //             './modules/dealers-location/dealers-location.module'
            //         ).then((m) => m.DealersLocationModule),
            // },
            {
                path: 'dealers/:id',
                canActivate: [GuardService],
                loadChildren: () =>
                    import('./modules/home-dealers/home-dealers.module').then(
                        (m) => m.HomeDealersModule
                    ),
            },
            {
                path: 'stock',
                canActivate: [GuardService],
                loadChildren: () =>
                    import('./modules/stock/stock.module').then(
                        (m) => m.StockModule
                    ),
            },
            {
                path: 'account',
                canActivate: [GuardService],
                loadChildren: () =>
                    import('./modules/home-user/home-user.module').then(
                        (m) => m.HomeUserModule
                    ),
            },

            // {
            //     path: 'home/sale',
            //     canActivate: [GuardService],
            //     loadChildren: () =>
            //         import('./modules/sale/sale.module').then(
            //             (m) => m.SaleModule
            //         ),
            // },
            // {
            //     path: 'home/buy',
            //     canActivate: [GuardService],
            //     loadChildren: () =>
            //         import('./modules/buy/buy.module').then((m) => m.buyModule),
            // },
            // {
            //     path: 'home/solicitudes',
            //     canActivate: [GuardService],
            //     loadChildren: () =>
            //         import(
            //             './modules/home-solicitud/home-solicitud.module'
            //         ).then((m) => m.HomeSolicitudModule),
            // },
        ],
    },
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
                    import('./modules/login/login.module').then(
                        (m) => m.LoginModule
                    ),
            },
            {
                path: 'family/home',
                canActivate: [GuardService],
                loadChildren: () =>
                    import('./modules/home/home.module').then(
                        (m) => m.HomeModule
                    ),
            },
            {
                path: 'family/request-sent',
                canActivate: [GuardService],
                loadChildren: () =>
                    import('./modules/requests-sent/requests-sent.module').then(
                        (m) => m.RequestsSentModule
                    ),
            },
            {
                path: 'family/request-received',
                canActivate: [GuardService],
                loadChildren: () =>
                    import(
                        './modules/requests-received/requests-received.module'
                    ).then((m) => m.RequestsReceivedModule),
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
