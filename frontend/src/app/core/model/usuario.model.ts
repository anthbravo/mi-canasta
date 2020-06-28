import { SolicitudAuth } from './solicitud.model';
import { Familia } from './familia.model';
import { TiendaService } from '../service/tienda.service';
import { Rol, RolPorUsuario } from './rol.model';
import { Tienda } from './tienda.model';

class Usuario {
    dni?: string;
    contrasena?: string;
    nombre?: string;
    apellidoPaterno?: string;
    apellidoMaterno?: string;
    correoElectronico?: string;
}

class UsuarioGet {
  dni?: string;
  nombre?: string;
  apellidoPaterno?: string;
  apellidoMaterno?: string;
  correoElectronico?: string;
}

class UsuarioAutenticacion {
    solicitud?: SolicitudAuth;
    usuario?: Usuario;
    familia?: Familia;
    tienda?: Tienda;
    rol?: Array<RolPorUsuario>;
}

class UsuarioPut {
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
