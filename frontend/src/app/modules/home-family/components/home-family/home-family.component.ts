import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/core/service/home.service';
import { ActivatedRoute } from '@angular/router';
import { FamiliaService } from 'src/app/core/service/familia.service';
import { UsuarioService } from 'src/app/core/service/usuario.service';
import { Rol, RolPorUsuario } from '../../../../core/model/rol.model';
import { RolService } from 'src/app/core/service/rol.service';

@Component({
    selector: 'app-home-family',
    templateUrl: './home-family.component.html',
    styleUrls: ['./home-family.component.scss'],
})
export class HomeFamilyComponent implements OnInit {
    switchValue = false;
    nombreFamilia = '';
    idFamily = -1;
    aceptaSolicitudes= false;
    roles: RolPorUsuario[] = [];
    userIsAdmin = false;
    integrantes:any  = [];

    constructor(
        private homeService: HomeService,
        private route: ActivatedRoute,
        private familiaService: FamiliaService,
        private rolService: RolService
    ) {}

    ngOnInit(): void {
       this.homeService.setStatus({ isLoginView: false });
        this.route.params.subscribe((e) => {
            this.idFamily = e.id;
            this.listarFamilia();
        });
        this.getRolUsuario();
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
                this.nombreFamilia = result.nombreUnico;
                this.switchValue =  result.aceptacionSolicitudes;
                this.listarMiembros();
            } catch (error) {
            console.log(error);
        }
    }
    // Arreglar eso según el json de get usuario
    async getRolUsuario(){
        console.log("Obtener Rol del Usuario Logeado");
         try {
          const res = await this.rolService.getRol(localStorage.getItem("dni"));
          this.roles = res;
          for(let i=0; i < this.roles.length; i++){
            if(this.roles[i].rolPerfilId == 1) this.userIsAdmin=true;
          }        
        }
        catch (error) {
          console.log(error);        
        }
      }
}
