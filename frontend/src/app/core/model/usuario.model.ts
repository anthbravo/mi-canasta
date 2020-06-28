import { SolicitudAuth } from './solicitud.model';
import { Familia } from './familia.model';
import { RolPorUsuario } from './rol.model';
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
    solicitud?: SolicitudAuth;
    usuario?: Usuario;
    familia?: Familia;
    tienda?: Tienda;
    rol?: Array<RolPorUsuario>;
}

export { Usuario, UsuarioAutenticacion };
