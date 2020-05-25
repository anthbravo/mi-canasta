class Familia {
  id?: number;
  nombreUnico?: string;
  cantidad?: string;
  aceptaSolicitudes?: boolean;
}

class FamiliaCreate {
  nombreUnico?: string;
  dni?: string;
}

export { Familia, FamiliaCreate };
