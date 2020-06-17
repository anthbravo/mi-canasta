class Familia {
  id?: number;
  nombreUnico?: string;
  cantidad?: number;
  aceptacionSolicitudes?: boolean;
}

class FamiliaCreate {
  nombreUnico?: string;
  dni?: string;
  aceptacionSolicitudes?: boolean;
}

class FamiliaNoIdDto {
  nombreUnico?: string;
  aceptacionSolicitudes?: boolean;
  cantidad?: number;
}


export { Familia, FamiliaCreate, FamiliaNoIdDto };
