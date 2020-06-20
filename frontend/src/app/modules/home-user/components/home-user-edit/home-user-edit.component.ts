import { Component, OnInit } from '@angular/core';
import { Usuario, UsuarioPut } from 'src/app/core/model/usuario.model';
import { UsuarioService } from 'src/app/core/service/usuario.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-user-edit',
  templateUrl: './home-user-edit.component.html',
  styleUrls: ['./home-user-edit.component.scss']
})
export class HomeUserDetailComponent implements OnInit {

  correo:string = "";
  contrasena:string = "";
  nuevaContrasena:string = "";
  repetirContrasena:string = "";
  user: Usuario = {};detail
  loadingButton:boolean = false;
  isShowModal:boolean = false;
  modalDescription:string = "";
  modalTitle:string = "";

  constructor(
    private usuarioService: UsuarioService,
    private route: Router
    ) { }

  ngOnInit(): void {
  }

  async putUsuario(){
    this.loadingButton = true;
    try {
        let usuarioPut = new UsuarioPut();
        usuarioPut.contrasena=this.contrasena;
        usuarioPut.correoElectronico=this.correo;
        usuarioPut.nuevaContrasena=this.nuevaContrasena;
        usuarioPut.repetirContrasena=this.repetirContrasena;
        await this.usuarioService.putUsuario(localStorage.getItem("dni"), usuarioPut);

        this.loadingButton = false;
        this.modalTitle="Éxito";
        this.modalDescription="Se realizó la actualización de datos";
        this.isShowModal = true;
    }
    catch (error) {
        this.loadingButton = false;
        if (error.error.exception === "ActualPasswordNotMatchException" ||
        error.error.exception === "NewPasswordNotMatchException" ||
        error.error.exception === "EmailWrongFormatException"){
            this.modalDescription = error.response.data.message;
            this.modalTitle = "Error"
            this.isShowModal = true;
        }
        console.log(error);
    }
  }

  async getUsuario(){
    try {
        const res = await this.usuarioService.getUsuario(localStorage.getItem("dni"));
        this.user = res;  
    }
    catch (error) {
        console.log(error);        
    }
  }

  volver(){
    this.route.navigate(['/home/user']);
  }

  closeModal() {
    this.isShowModal = false;
    location.reload();
  }


}
