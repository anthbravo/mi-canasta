class Tienda {
    id?: number;
    descripcion?: string;
    direccion?: string;
    latitud?: string;
    limite?: number;
    longitud?: string;
    horario?: string;
    tipo?: string;
}

class TiendaUsuarioDto {
    id?: number;
    descripcion?: string;
    dni?: string;
}

export { Tienda, TiendaUsuarioDto };
