import { Familia } from './familia.model';
import { Rol } from './rol.model';
import { TiendaService } from '../service/tienda.service';
import { Tienda } from './tienda.model';
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
  tienda?: Tienda;
  rol?: Array<Rol>;
}

class UsuarioGet {
  dni?: string;
  nombre?: string;
  apellidoPaterno?: string;
  apellidoMaterno?: string;
  correoElectronico?: string;
}

class UsuarioPut {
  correoElectronico?: string;
  contrasena?: string;
  nuevaContrasena?: string;
  repetirContrasena?: string;
}

export { Usuario, UsuarioAutenticacion, UsuarioGet, UsuarioPut };
