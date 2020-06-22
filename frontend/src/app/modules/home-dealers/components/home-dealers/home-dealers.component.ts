import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/core/service/home.service';
import { ActivatedRoute } from '@angular/router';
import { Rol, RolPorUsuario } from '../../../../core/model/rol.model';
import { RolService } from 'src/app/core/service/rol.service';
import { Usuario } from 'src/app/core/model/usuario.model';
import { TiendaService } from 'src/app/core/service/tienda.service';

@Component({
  selector: 'app-home-dealers',
  templateUrl: './home-dealers.component.html',
  styleUrls: ['./home-dealers.component.scss']
})
export class HomeDealersComponent implements OnInit {
  dni = '';
  idTienda = -1;
  roles: RolPorUsuario[] = [];
  userIsAdmin = false;
  integrantes: Usuario[]  = [];
  numIntegrantes = 0;
  unicoAdmin = false;
  constructor(
      private homeService: HomeService,
      private tiendaService: TiendaService,
      private route: ActivatedRoute,
      private rolService: RolService
  ) {}

  ngOnInit(): void {
    this.homeService.setStatus({ isLoginView: false });
    this.route.params.subscribe((e) => {
      this.idTienda = e.id;
      this.listarMiembros();
    });
    this.getRolUsuario();
  }

  async postUsuarioInTienda(){
    try{
      const res = await this.tiendaService.postUsuarioInTienda(this.idTienda,
      this.dni,
    );
      console.log(res);
    } catch (error) {
      console.log(error);
    }
  }

  async isUnicoAdmin(){
    let cont = 0;
    for (let i = 0; i < this.numIntegrantes; i++){
        // tslint:disable-next-line: triple-equals
        if (await this.isAdmin(this.integrantes[i].dni) == true) { cont++; }
    }
    // tslint:disable-next-line: triple-equals
    if (this.userIsAdmin == true && cont == 1) { this.unicoAdmin = true; }
    console.log(this.unicoAdmin);
}

    async isAdmin(dniIntegrante: string){
      let cont = 0;
      let rolesAux: RolPorUsuario[] = [];
      try {
        const res = await this.rolService.getRol(dniIntegrante);
        rolesAux = res;
        // tslint:disable-next-line: prefer-for-of
        for (let i = 0; i < rolesAux.length; i++){
          // tslint:disable-next-line: triple-equals
          if (rolesAux[i].rolPerfilId == 3) { cont++; }
        }
        if (cont > 0) { return true; }
        else { return false; }
      }
      catch (error) {
        console.log(error);
      }
    }

    async listarTienda() {
      try {
        const result = await this.tiendaService.listarTienda(this.idTienda);
        this.listarMiembros();
      } catch (error) {
        console.log(error);
      }
    }

    async listarMiembros() {
        try {
        const result = await this.tiendaService.listarMiembros(
          this.idTienda
        );
        this.integrantes = result;
        this.numIntegrantes = this.integrantes.length;
        this.isUnicoAdmin();
      } catch (error) {
        console.log(error);
      }
    }

    async getRolUsuario(){
      try {
       const res = await this.rolService.getRol(localStorage.getItem('dni'));
       this.roles = res;
       // tslint:disable-next-line: prefer-for-of
       for (let i = 0; i < this.roles.length; i++){
         // tslint:disable-next-line: triple-equals
         if (this.roles[i].rolPerfilId == 3) { this.userIsAdmin = true; }
       }
     }
     catch (error) {
       console.log(error);
     }
 }

}
