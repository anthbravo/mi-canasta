import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/core/service/home.service';
import { SolicitudService } from '../../../../core/service/solicitud.service';
import { AuthService } from '../../../../core/service/auth.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-requests-sent',
  templateUrl: './requests-sent.component.html',
  styleUrls: ['./requests-sent.component.scss'],
})
export class RequestsSentComponent implements OnInit {
  mock = [{ familyName: 'Familia82BDH' }];
  nombreFam = [];
  usuario: any;
  datoUsuario: any;
  constructor(
    private homeService: HomeService,
    private solicitudService: SolicitudService,
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.homeService.setStatus({ isLoginView: false });
    this.usuario = this.authService.getUsuarioAutenticacion();
    this.getSolicitud();
  }
  async getSolicitud() {
    try {
      this.nombreFam = [];
      console.log(this.usuario);
      let dni = this.usuario.usuario.dni;
      const input = await this.solicitudService.obtenerSolicitudes(dni);
      this.datoUsuario = input;
      if (this.datoUsuario) {
        this.nombreFam = [
          {
            familyName: this.datoUsuario.nombreFamilia,
            dni: dni,
          },
        ];
      } else {
        this.router.navigate(['/family/home']);
      }
    } catch (error) {
      console.log(error);
    }
  }
}
