import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/core/model/usuario.model';
import { UsuarioService } from '../../../../core/service/usuario.service';
import { RolService } from '../../../../core/service/rol.service';
import { RolPorUsuario } from '../../../../core/model/rol.model';
import { HomeService } from 'src/app/core/service/home.service';

@Component({
  selector: 'app-home-user',
  templateUrl: './home-user.component.html',
  styleUrls: ['./home-user.component.scss']
})
export class HomeUserComponent implements OnInit {
  loaded:boolean = false;
  dni:string =  "";
  src: string ="";
  user: Usuario = {};
  descriptionRoles: string ="Roles en Grupo Familiar";
  userType:number = 0; //familia
  responsable: string ="Responsable de compra";
  roles: RolPorUsuario[]=[];

  constructor(
    private usuarioService: UsuarioService,
    private rolService: RolService,
    private homeService: HomeService
  ) {}
    
  ngOnInit(): void {
    this.homeService.setStatus({ isLoginView: false });
    this.dni = localStorage.getItem("dni");
    this.src = "https://api.qrserver.com/v1/create-qr-code/?data="+this.dni+"&amp;size=100x100";
    this.getUsuario();
    this.getRolUsuario();
    this.loaded = true;
  }

  async getUsuario(){
    try {
        const res = await this.usuarioService.getUsuario(this.dni);
        this.user = res;  
    }
    catch (error) {
        console.log(error);        
    }
  }
  async getRolUsuario(){
    try {
     const res = await this.rolService.getRol(this.dni);
     this.roles = res;     
    }
    catch (error) {
     console.log(error);        
    }
  }

  changeProfile(){

  }
}
