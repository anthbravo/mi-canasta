import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/core/service/home.service';
import { ActivatedRoute } from '@angular/router';
import { FamiliaService } from 'src/app/core/service/familia.service';
import { UsuarioService } from 'src/app/core/service/usuario.service';
import { Rol } from '../../../../core/model/rol.model';

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
    roles:any = [];
    userIsAdmin = false;
    integrantes:any  = [];
    constructor(
        private homeService: HomeService,
        private route: ActivatedRoute,
        private familiaService: FamiliaService,
        private usuarioService: UsuarioService
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
                this.nombreFamilia = result.nombre;
                this.switchValue =  result.aceptaSolicitudes;
                this.listarMiembros();
            } catch (error) {
            console.log(error);
        }
    }
    // Arreglar eso según el json de get usuario
    async getRolUsuario(){
        console.log("Obtener Rol del Usuario Logeado");
         try {
          const res = await this.usuarioService.getUsuario(localStorage.getItem("dni"));
          this.roles = res.rol;
          console.log(res);
          for(let i=0; i < this.roles.length; i++){
            if(this.roles[i].rolPerfilId == 1) this.userIsAdmin=true;
            console.log(this.userIsAdmin);
          }        
        }
        catch (error) {
          console.log(error);        
        }
      }
}
