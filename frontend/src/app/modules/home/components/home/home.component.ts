import { AuthService } from 'src/app/core/service/auth.service';
import { Component, OnInit } from '@angular/core';
import { FamiliaService } from 'src/app/core/service/familia.service';
import { HomeService } from 'src/app/core/service/home.service';
import { FamiliaCreate } from 'src/app/core/model/familia.model';
import { SolicitudService } from '../../../../core/service/solicitud.service';
import { Solicitud } from 'src/app/core/model/solicitud.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  grupoFamiliar = '';

  errorFlagModal = false;
  errorFlagModalUnirse = false;

  isGrupoFamiliarText = false;

  loadingCreaFamiliarButton = false;
  loadingUnirseFamiliaButton = false;

  constructor(
    private familiaService: FamiliaService,
    private route: Router,
    private homeService: HomeService,
    private solicitudService: SolicitudService
  ) {}

  ngOnInit(): void {
    this.homeService.setStatus({ isLoginView: false });
  }

  async crearGrupo() {
    this.loadingCreaFamiliarButton = true;
    try {
      let newFamily =  new FamiliaCreate()
      newFamily.aceptacionSolicitudes = true;
      newFamily.dni =  localStorage.getItem("dni");
      newFamily.familiaNombre =  this.grupoFamiliar;

      const res = await this.familiaService.crearFamilia(newFamily);
    } catch (error) {
      console.log(error);
      this.loadingCreaFamiliarButton = false;
      this.errorFlagModal = true;
    }
  }

  async unirseGrupo() {
    console.log('Unirse grupo');
    this.loadingUnirseFamiliaButton = true;
    try {
      let newSolicitud =  new Solicitud()
      newSolicitud.dni =  localStorage.getItem("dni");
      newSolicitud.familiaNombre =  this.grupoFamiliar;
      const res = await this.solicitudService.crearSolicitud(newSolicitud);
      console.log(res);
      this.route.navigate(['/home/solicitudes']);
    } catch (error) {
      console.log(error);
      this.loadingUnirseFamiliaButton = false;
      this.errorFlagModalUnirse = true;
    }
  }

  cerrarModal() {
    this.errorFlagModal = false;
  }
  cerrarModalUnirse() {
    this.errorFlagModalUnirse = false;
  }
}
