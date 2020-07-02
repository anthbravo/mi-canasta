import { FooterFamilyComponent } from './components/footer-family/footer-family.component';
import { FooterDealerComponent } from './components/footer-dealer/footer-dealer.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LayoutRoutingModule } from './layout-routing.module';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { LayoutComponent } from './components/layout/layout.component';
import { LayoutDealerComponent } from './components/layout-dealer/layout-dealer.component';
import { LayoutFamilyComponent } from './components/layout-family/layout-family.component';

@NgModule({
    declarations: [
        HeaderComponent,
        FooterComponent,
        LayoutComponent,
        FooterDealerComponent,
        FooterFamilyComponent,
        LayoutDealerComponent,
        LayoutFamilyComponent,
    ],
    imports: [CommonModule, LayoutRoutingModule],
    exports: [LayoutComponent, LayoutDealerComponent, LayoutFamilyComponent],
})
export class LayoutModule {}
