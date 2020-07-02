import { Component, OnInit } from '@angular/core';
import { Usuario, UsuarioPut, UsuarioGet } from 'src/app/core/model/usuario.model';
import { UsuarioService } from 'src/app/core/service/usuario.service';
import { Router } from '@angular/router';
import { HomeService } from 'src/app/core/service/home.service';
import { AuthService } from 'src/app/core/service/auth.service';

@Component({
  selector: 'app-home-user-edit',
  templateUrl: './home-user-edit.component.html',
  styleUrls: ['./home-user-edit.component.scss']
})
export class HomeUserEditComponent implements OnInit {

  correo:string = "";
  contrasena:string = "";
  nuevaContrasena:string = "";
  repetirContrasena:string = "";
  user: UsuarioGet = {};
  loadingButton:boolean = false;
  isShowModal:boolean = false;
  modalDescription:string = "";
  modalTitle:string = "";

  constructor(
    private usuarioService: UsuarioService,
    private homeService: HomeService,
    private route: Router,
    private authService: AuthService
    ) { }

  ngOnInit(): void {
    this.homeService.setStatus({ isLoginView: false });
    this.getUsuario();
  }

  async putUsuario(){
    this.loadingButton = true;
    try {
        let usuarioPut = new UsuarioPut();
        usuarioPut.contrasena=this.contrasena;
        usuarioPut.correoElectronico=this.correo;
        usuarioPut.nuevaContrasena=this.nuevaContrasena;
        usuarioPut.repetirContrasena=this.repetirContrasena;
        await this.usuarioService.putUsuario(this.authService.getUsuarioAutenticacion().usuario.dni, usuarioPut);

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
        const res = await this.usuarioService.getUsuario(this.authService.getUsuarioAutenticacion().usuario.dni);
        this.user = res;
        this.correo = this.user.correoElectronico;
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
