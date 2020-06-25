import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/core/service/auth.service';
import { Usuario } from 'src/app/core/model/usuario.model';
import { Router } from '@angular/router';
import { HomeService } from 'src/app/core/service/home.service';
import { ValidacionService } from 'src/app/core/service/validacion.service';
import { ErrorGeneric } from 'src/app/core/model/error.model';
import { environment } from 'src/environments/environment';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
    usuario: Usuario;

    isShowConfirmationModal = false;

    isShowErrorModal = false;

    isShowWarningModal = false;

    loadingLoginButton = false;

    disableButton = false;

    error: ErrorGeneric;

    dataHorizontaBar = [
        {text: "2kg", color: "red", value: 2},
        {text: "1kg", color: "orange", value: 1},
      ]
    constructor(
        private authService: AuthService,
        private route: Router,
        private homeService: HomeService
    ) {}

    ngOnInit(): void {
        this.usuario = new Usuario();
        this.error = new ErrorGeneric();
        this.error.title = 'Error';
    }

    async autenticar() {
        this.loadingLoginButton = true;
        this.disableButton = true;

        try {
            if (!ValidacionService.validarDni(this.usuario.dni)) {
                throw new Error('FormatDniException');
            } else if (
                !ValidacionService.validarContrasena(this.usuario.contrasena)
            ) {
                throw new Error('FormatContrasenaException');
            }
            const usuarioAutenticacion = await this.authService.authentication(
                this.usuario
            );

            sessionStorage.setItem('dni', this.usuario.dni);

            this.authService.saveUsuarioAutenticacion(usuarioAutenticacion);

            let token = JSON.stringify(
                await this.authService.generateToken(this.usuario)
            );
            sessionStorage.setItem(environment.TOKEN_NAME, token);

            if (usuarioAutenticacion.familia != null) {
                this.route.navigate([
                    `/home/family/${usuarioAutenticacion.familia.id}`,
                ]);
            } else {
                this.route.navigate(['/home']);
            }

            this.homeService.setStatus({ isLoginView: false });
        } catch (error) {
            if (
                error.error.exception === 'UserLoginNotFoundException' ||
                error.error.exception === 'UserLoginIncorrectException'
            ) {
                this.error.description =
                    'El usuario o contraseña ingresado es incorrecto';
            } else if (error.message === 'FormatDniException') {
                this.error.description =
                    'El DNI ingresado debe contener 8 caracteres y ser solo números';
            } else if (error.message === 'FormatContrasenaException') {
                this.error.description =
                    'La contraseña ingresada no debe estar vacía, tener mas de 50 caracteres o contener espacios en blanco';
            }

            this.openErrorModal();
            this.loadingLoginButton = false;
            this.disableButton = false;
        }
    }

    openErrorModal() {
        this.isShowErrorModal = true;
    }

    closeErrorModal() {
        this.isShowErrorModal = false;
    }
}
