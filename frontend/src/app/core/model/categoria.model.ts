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

export { CategoriaGet, CategoriaLimit };