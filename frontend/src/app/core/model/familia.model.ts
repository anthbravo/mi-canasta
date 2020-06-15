class Familia {
  id?: number;
  nombreUnico?: string;
  cantidad?: number;
  aceptacionSolicitudes?: boolean;
}

class FamiliaCreate {
  familiaNombre?: string;
  dni?: string;
  aceptacionSolicitudes?:boolean =  true;

}

class FamiliaNoIdDto {
  nombreUnico?: string;
  aceptacionSolicitudes?: boolean;
  cantidad?: number;
}


export { Familia, FamiliaCreate, FamiliaNoIdDto };
