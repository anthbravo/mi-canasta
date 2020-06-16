import { Component, OnInit } from '@angular/core';
import { UsuarioAutenticacion } from 'src/app/core/model/usuario.model';
import { UsuarioService } from '../../../../core/service/usuario.service';
import { RolService } from '../../../../core/service/rol.service';
import { RolPorUsuario } from '../../../../core/model/rol.model';

@Component({
  selector: 'app-home-user',
  templateUrl: './home-user.component.html',
  styleUrls: ['./home-user.component.scss']
})
export class HomeUserComponent implements OnInit {

  name:string = "UserPage";
  dni:string =  "";
  src: string ="";
  user: UsuarioAutenticacion;
  descriptionRoles: string ="Roles en Grupo Familiar";
  userType:number = 0; //familia
  responsable: string ="Responsable de compra";
  roles: RolPorUsuario[]=[];

  constructor(
    private usuarioService: UsuarioService,
    private rolService: RolService
  ) {}

  ngOnInit(): void {
    this.dni = localStorage.getItem("dni");
    this.src = "https://api.qrserver.com/v1/create-qr-code/?data="+this.dni+"&amp;size=100x100";
    this.getUsuario();
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
  async getRolUsuario(){
    try {
     const res = await this.rolService.getRol(localStorage.getItem("dni"));
     this.roles = res;     
    }
    catch (error) {
     console.log(error);        
    }
  }

}
