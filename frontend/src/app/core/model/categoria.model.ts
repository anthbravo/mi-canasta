class CategoriaGet {
    id?: number;
    descripcion?: string;
    tipoDeUnidad?: string;
    limite?: number;
    restante?: number;
}

class CategoriaLimit {
    cantidadXPersona?: number;
    categoriaId?: number;
    id?: number;
}

class CategoriaMostrar {
    categoriaId?: number;
    consumido?: number;
    restante?: number;
    descripcion?: string;
}

export { CategoriaGet, CategoriaLimit, CategoriaMostrar };