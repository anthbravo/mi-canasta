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

export { Tienda, TiendaUsuarioDto };
