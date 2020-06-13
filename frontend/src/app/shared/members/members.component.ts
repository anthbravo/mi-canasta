import { Component, OnInit, Input } from '@angular/core';
import { FamiliaService } from '../../core/service/familia.service';
import { UsuarioService } from '../../core/service/usuario.service';

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

  roles:any = [];
  errorFlagModal = false;
  errorFlagModalAdmin = false;
  userToDeleteIsAdmin = false;
  isShowConfirmationModal = false;

  data = [1,2,3,4,5,6,7]
  constructor(private familiaService: FamiliaService, private usuarioService: UsuarioService) { }

  ngOnInit(): void {
    //this.getRolUsuario();
  }

  async deleteUsuariofromFamilia(){
    console.log("Borrar usuario de familia");
     try {
      if(this.userIsAdmin == true){
        if(this.userToDeleteIsAdmin == true){
          this.errorFlagModal = true;
          // El usuario a borrar es un administrador
        }
        else{
          const res = await this.familiaService.eliminarIntegrante(this.nombreFamilia, this.dni);
          console.log(res);
          location.reload();
        }
      }
      else {
        this.errorFlagModalAdmin = true;
        // No cuenta con privilegios de administardor
      }
    }
    catch (error) {
      console.log(error);        
    }
  }

  async getRolUsuario(){
    console.log("Obtener Rol del Usuario");
     try {
      
      const res = await this.usuarioService.getUsuario(this.dni);
      this.roles = res.rol;
      console.log(res);
      console.log(this.roles);
      for(let i=0; i < this.roles.length; i++){
        if(this.roles[i].rolPerfilId == 1) this.userToDeleteIsAdmin=true;
      }        
    }

    catch (error) {
      console.log(error);        
    }
  }

  cerrarModal() {
    this.errorFlagModal = false;
  }
  cerrarModalAdmin(){
     this.errorFlagModalAdmin = false;
  }
  abrirModalConfirmacion(){
    this.isShowConfirmationModal=true;
  }
  cerrarModalConfirmacion(){
    this.isShowConfirmationModal=false;
  }
}
