class Familia {
  familiaId?: number;
  nombre?: string;
  cantidad?: number;
  aceptaSolicitudes?: boolean;
}

class FamiliaCreate {
  familiaNombre?: string;
  dni?: string;
  aceptaSolicitudes?:boolean =  true;

}

export { Familia, FamiliaCreate };
