import { Component, OnInit, Input } from '@angular/core';
import { FamiliaService } from '../../core/service/familia.service';
import { RolPorUsuario } from '../../core/model/rol.model';
import { RolService } from 'src/app/core/service/rol.service';
import { ErrorGeneric } from 'src/app/core/model/error.model';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/core/service/auth.service';

@Component({
  selector: 'app-members',
  templateUrl: './members.component.html',
  styleUrls: ['./members.component.scss']
})
export class MembersComponent implements OnInit {

  @Input()
  person:any;
  @Input()
  nombreFamilia = "";
  @Input()
  idFamilia = -1;
  @Input()
  dni = "";
  @Input()
  userIsAdmin = false;
  @Input()
  numIntegrantes: number;
  @Input()
  unicoAdmin: boolean;
  @Input()
  idTienda: any;
  @Input()
  rol: any = false;

  roles:RolPorUsuario[] = [];
  descriptionErrorModal: string;
  descriptionConfirModal: string;
  errorFlagModal = false;
  userToDeleteIsAdmin = false;
  isShowConfirmationModal = false;
  error: ErrorGeneric;

  data = [1,2,3,4,5,6,7]
  constructor(
    private familiaService: FamiliaService,
    private rolService: RolService,
    private route: Router,
    private authService: AuthService
    ) { }

  ngOnInit(): void {
    this.getRolUsuario();
  }

  deleteUsuarioFromFamilia(){
    if( this.authService.getUsuarioAutenticacion().usuario.dni == this.dni ){
      this.deleteYo();
    }
    else {
      this.deleteOtroUsuario();
    }
  }

  async deleteYo(){
    try {
      if(this.numIntegrantes > 1 && this.unicoAdmin == true){
        this.descriptionErrorModal = "Debe asignar otro administrador para poder salir del grupo familiar";
        this.errorFlagModal = true;
        this.cerrarModalConfirmacion();
      }
      else {
        const res = await this.familiaService.eliminarIntegrante(this.nombreFamilia, this.dni);
        this.route.navigate(['/home']);
      }
    }
    catch (error) {
      console.log(error);        
   }
 }

  async deleteOtroUsuario(){
     try {
      if(this.userIsAdmin == true){
        if(this.userToDeleteIsAdmin == true){
          this.descriptionErrorModal = "No puede eliminar a un administrador";
          this.errorFlagModal = true;
          this.cerrarModalConfirmacion();
        }
        else{
          const res = await this.familiaService.eliminarIntegrante(this.nombreFamilia, this.dni);
          console.log(res);
          location.reload();
        }
      }
      else {
        this.descriptionErrorModal = "No se cuenta con privilegios de administrador";
        this.errorFlagModal = true;
        this.cerrarModalConfirmacion();
      }
    }
    catch (error) {
      console.log(error);        
    }
  }

  async getRolUsuario(){
     try {
      const res = await this.rolService.getRol(this.dni);
      this.roles = res;
      for(let i=0; i < this.roles.length; i++){
        if(this.roles[i].rolPerfilId == 1) {
        this.userToDeleteIsAdmin=true;
        this.rol = true;
        }else{
          this.rol = false;
        }
      }        
    }
    catch (error) {
      console.log(error);
    }
  }

  cerrarModal() {
    this.errorFlagModal = false;
  }

  abrirModalConfirmacion(){
    if( this.authService.getUsuarioAutenticacion().usuario.dni == this.dni ){
      if(this.numIntegrantes == 1)
        this.descriptionConfirModal="¿Desea abandonar el grupo familiar? Toda la información de la familia se perderá";
      else this.descriptionConfirModal="¿Desea abandonar el grupo familiar?";
    }
    else {
      this.descriptionConfirModal="¿Desea eliminar al usuario seleccionado?";
    }
    this.isShowConfirmationModal=true;
  }
  cerrarModalConfirmacion(){
    this.isShowConfirmationModal=false;
  }
}
