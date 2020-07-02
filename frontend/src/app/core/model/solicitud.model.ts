export class Solicitud {
    familiaNombre?: string;
    dni?: string;
}

export class SolicitudCreated {
    nombreFamilia?: string;
    dni?: string;
}

export class SolicitudAuth {
    nombreFamilia?: string;
    dni?: string;
}

export class SolicitudResponse {
    dni?: string;
    familiaId?: Number;
}
