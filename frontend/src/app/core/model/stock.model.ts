class Stock {
    tiendaId?: number;
    productoId?: number;
    cantidad?: number;
}

class StockGet {
    productoId?: number;
    tiendaId?: number;
    cantidad?: number;
}

class StockPut {
    cantidad?: number;
}

export { Stock, StockGet, StockPut };
