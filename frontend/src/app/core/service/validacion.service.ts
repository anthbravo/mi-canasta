const validacionDni = /^[0-9]{8}$/;
const validacionContrasena = /^\S{1,50}$/;

export class ValidacionService {
  static validarDni(dni) {
    return validacionDni.test(dni);
  }

  static validarContrasena(contrasena) {
    return validacionContrasena.test(contrasena);
  }
}
