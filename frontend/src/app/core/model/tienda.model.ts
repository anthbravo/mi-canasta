class Tienda {
    id?: number;
    descripcion?: string;
    direccion?: string;
    limite?: number;
    latitud?: string;
    longitud?: string;
    horario?: string;
}

class TiendaUsuarioDto {
    id?: number;
    descripcion?: string;
    dni?: string;
}

class TiendaGet {
    idTienda?: number;
    descripcion?: string;
    direccion?: string;
    latitud?: string;
    longitud?: string;
    horario?: string;
    contrasena?: string;
    limite?: number;
  }

class TiendaPut {
    descripcion?: string;
    direccion?: string;
    latitud?: string;
    longitud?: string;
    horario?: string;
    contrasena?: string;
  }

class TiendaLimiteDto{
      limite?: number;
  }

export { Tienda, TiendaUsuarioDto, TiendaGet, TiendaLimiteDto, TiendaPut };
