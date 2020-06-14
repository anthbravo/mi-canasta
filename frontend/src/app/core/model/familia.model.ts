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

export { Familia, FamiliaCreate };
