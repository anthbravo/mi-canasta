import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/core/service/home.service';
import { ActivatedRoute } from '@angular/router';
import { FamiliaService } from 'src/app/core/service/familia.service';

@Component({
    selector: 'app-home-family',
    templateUrl: './home-family.component.html',
    styleUrls: ['./home-family.component.scss'],
})
export class HomeFamilyComponent implements OnInit {
    switchValue = false;

    nombreFamilia = '';
    idFamily = -1;
    mock = [
        {
            name: 'Anthony',
            dni: '10101010',
            roles: ['Admin', 'Comprador'],
            categorias: ['Mercancia'],
        },
        {
            name: 'Jimena',
            dni: '1245789',
            roles: ['Comprador'],
            categorias: ['Alimentos'],
        },
    ];

    integrantes:any  = [];
    constructor(
        private homeService: HomeService,
        private route: ActivatedRoute,
        private familiaService: FamiliaService
    ) {}

    ngOnInit(): void {
        this.homeService.setStatus({ isLoginView: false });
        this.route.params.subscribe((e) => {
            this.idFamily = e.id;
            this.listarFamilia();
        });
    }

    async listarMiembros() {
        try {
            const result = await this.familiaService.listaMiembrosFamilia(
                this.nombreFamilia
            );

            this.integrantes= result;

        } catch (error) {
            console.log(error);
        }
    }

    async listarFamilia() {
        try {
            const result = await this.familiaService.listarFamilia(
                this.idFamily
                );
                this.nombreFamilia = result.nombre;
                this.switchValue =  result.aceptaSolicitudes;
                this.listarMiembros();
            } catch (error) {
            console.log(error);
        }
    }
}
