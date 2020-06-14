export class Rol {
  id: number;
  descripcion: string;
  perfilId: number;
}

export class RolPorUsuario {
  dni: string;
  rolPerfilId: number;
}