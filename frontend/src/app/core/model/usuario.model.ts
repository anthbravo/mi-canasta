import { Familia } from './familia.model';
import { Rol } from './rol.model';
class Usuario {
  dni?: string;
  contrasena?: string;
  nombre?: string;
  apellidoPaterno?: string;
  apellidoMaterno?: string;
  correoElectronico?: string;
}

class UsuarioAutenticacion {
  dni?: string;
  contrasena?: string;
  nombre?: string;
  apellidoPaterno?: string;
  apellidoMaterno?: string;
  correoElectronico?: string;
  familia?: Familia;
  rol?: Array<Rol>;
  solicitud?:string
}

export { Usuario, UsuarioAutenticacion };
