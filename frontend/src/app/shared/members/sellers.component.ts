import { Component, OnInit, Input } from '@angular/core';
import { FamiliaService } from '../../core/service/familia.service';
import { TiendaService } from '../../core/service/tienda.service';
import { RolPorUsuario } from '../../core/model/rol.model';
import { RolService } from 'src/app/core/service/rol.service';
import { ErrorGeneric } from 'src/app/core/model/error.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sellers',
  templateUrl: './sellers.component.html',
  styleUrls: ['./sellers.component.scss']
})
export class SellersComponent implements OnInit {

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
  error: ErrorGeneric;

  data = [1,2,3,4,5,6,7]
  constructor(
    private familiaService: FamiliaService,
    private rolService: RolService,
    private route: Router
    ) { }

  ngOnInit(): void {
    this.getRolUsuario();
  }

  async getRolUsuario(){
    try {
     
     const res = await this.rolService.getRol(this.dni);
     this.roles = res;
     for(let i=0; i < this.roles.length; i++){
       if(this.roles[i].rolPerfilId == 3) {
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
}
