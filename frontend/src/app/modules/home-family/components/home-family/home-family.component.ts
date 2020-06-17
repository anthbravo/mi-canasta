import { NzSwitchModule } from 'ng-zorro-antd/switch';
import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/core/service/home.service';
import { ActivatedRoute } from '@angular/router';
import { FamiliaService } from 'src/app/core/service/familia.service';
import { Rol, RolPorUsuario } from '../../../../core/model/rol.model';
import { RolService } from 'src/app/core/service/rol.service';
import { Usuario } from 'src/app/core/model/usuario.model';
import { FamiliaNoIdDto } from 'src/app/core/model/familia.model';


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
    integrantes:Usuario[]  = [];
    numIntegrantes = 0;
    unicoAdmin = false;
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

    ngOnChanges(){
        try{
            this.familiaService.desactivarSolicitudes(this.idFamily);
            console.log(this.idFamily);
        } catch (error){
            console.log(error);
        }
    }

    async isUnicoAdmin(){
        let cont = 0;
        for(let i = 0; i < this.numIntegrantes; i++){
            if(await this.isAdmin(this.integrantes[i].dni) == true) cont++;
        }
        if(this.userIsAdmin==true && cont==1) this.unicoAdmin = true;
        console.log(this.unicoAdmin);
    }

    async listarMiembros() {
        try {
            const result = await this.familiaService.listaMiembrosFamilia(
                this.nombreFamilia
            );

            this.integrantes= result;
            this.numIntegrantes = this.integrantes.length;
            this.isUnicoAdmin();
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

    async getRolUsuario(){
         try {
          const res = await this.rolService.getRol(sessionStorage.getItem("dni"));
          this.roles = res;
          for(let i=0; i < this.roles.length; i++){
            if(this.roles[i].rolPerfilId == 1) this.userIsAdmin=true;
          }        
        }
        catch (error) {
          console.log(error);        
        }
    }

    async isAdmin(dniIntegrante: string){
        let cont = 0;
        let rolesAux: RolPorUsuario[] = [];
        try {
         const res = await this.rolService.getRol(dniIntegrante);
         rolesAux = res;
         for(let i=0; i < rolesAux.length; i++){
           if(rolesAux[i].rolPerfilId == 1) cont++;
         }
         if(cont > 0) return true;
         else return false;
       }
       catch (error) {
         console.log(error);        
       }
   }

}

