import { AuthService } from 'src/app/core/service/auth.service';
import { Component, OnInit } from '@angular/core';
import { FamiliaService } from 'src/app/core/service/familia.service';
import { HomeService } from 'src/app/core/service/home.service';
import { FamiliaCreate } from 'src/app/core/model/familia.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  grupoFamiliar = '';

  errorFlagModal = false;

  isGrupoFamiliarText = false;

  loadingCreaFamiliarButton = false;

  constructor(
    private familiaService: FamiliaService,
    private authService: AuthService,
    private homeService: HomeService
  ) {}

  ngOnInit(): void {
    this.homeService.setStatus({ isLoginView: false });
  }

  async crearGrupo() {
    this.loadingCreaFamiliarButton = true;
    try {
      let newFamily =  new FamiliaCreate()
      newFamily.aceptaSolicitudes = true;
      newFamily.dni =  localStorage.getItem("dni")
      newFamily.familiaNombre =  this.grupoFamiliar;

      const res = await this.familiaService.crearFamilia(newFamily);
    } catch (error) {
      console.log(error);
      this.loadingCreaFamiliarButton = false;
      this.errorFlagModal = true;
    }
  }

  unirseGrupo() {
    console.log('Unirse grupo');
  }

  cerrarModal() {
    this.errorFlagModal = false;
  }
}
