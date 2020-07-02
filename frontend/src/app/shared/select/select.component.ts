import { Component, OnInit, Input } from '@angular/core';
import { FamiliaService } from 'src/app/core/service/familia.service';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/core/model/usuario.model';
import { HomeService } from 'src/app/core/service/home.service';
import { ActivatedRoute } from '@angular/router';
import { RolPorUsuario } from 'src/app/core/model/rol.model';
import { RolService } from 'src/app/core/service/rol.service';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.scss'],
})
export class SelectComponent implements OnInit {
  listOfOption: Array<{ value: string; label: string }> = [];
  listOfSelectedValue = ["Administrador"];

  @Input()
  dni = "";
  @Input()
  options:any;

  constructor(
    private familiaService: FamiliaService,
    private route: Router
    ) { }

  ngOnInit(): void {
   this.cambiarRolUsuario();
  }

cambiarRolUsuario(){
  const children: string[] = ["Administrador", "Miembro"];
    this.listOfOption = children.map((item) => {
    this.familiaService.cambiarRolUsuario(localStorage.getItem("dni"));
    return {
      value: item,
      label: item,
    };
  });
}


}
