class Familia {
  id?: number;
  nombreUnico?: string;
  cantidad?: string;
  aceptaSolicitudes?: boolean;
}

class FamiliaCreate {
  familiaNombre?: string;
  dni?: string;
  aceptaSolicitudes?:boolean =  true;

}

export { Familia, FamiliaCreate };
