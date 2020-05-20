import {Component, OnInit} from '@angular/core';
import {FamiliaService} from 'src/app/core/service/familia.service';

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

  constructor(private familiaService: FamiliaService) {}

  ngOnInit(): void {}

  async crearGrupo() {
    this.loadingCreaFamiliarButton = true;
    try {
      const res = await this.familiaService.crearFamilia({
        aceptaSolicitudes: true,
        dni: localStorage.getItem("dni"),
        familiaNombre: this.grupoFamiliar,
      });
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
