import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Familia, FamiliaCreate, FamiliaNoIdDto } from '../model/familia.model';
import { Usuario } from 'src/app/core/model/usuario.model';

@Injectable({
  providedIn: 'root',
})

export class FamiliaService {
  
  constructor(private httpClient: HttpClient) {}

  async crearFamilia(familia: FamiliaCreate) {
    return await this.httpClient
      .post(`${environment.url_api}/familias`, familia)
      .toPromise();
  }

  async listarFamilia(id: any){
    return await this.httpClient.get<Familia>(`${environment.url_api}/familias/${id}`)
    .toPromise();
  }

  async listaMiembrosFamilia(nombreFamilia:string){
    return await this.httpClient
      .get<Array<Usuario>>(`${environment.url_api}/familias/${nombreFamilia}/usuarios`)
      .toPromise()
  }

  async eliminarIntegrante(nombreFamilia:string,dni:string){
    return await this.httpClient
      .delete(`${environment.url_api}/familias/${nombreFamilia}/usuarios/${dni}`)
      .toPromise()
  }

  async actualizarFamiliar(nombreFamilia:string){
    return await this.httpClient
      .put(`${environment.url_api}/familias/${nombreFamilia}`,null)
      .toPromise
  }

  async desactivarSolicitudes(idFamilia: number){
    return await this.httpClient
      .put(`${environment.url_api}/familias/${idFamilia}`, null)
      .toPromise();
  }

  async cambiarRolUsuario(dni:string){
    return await this.httpClient
    .put(`${environment.url_api}/familias/${dni}/rolesPorUsuario`, null)
    .toPromise();
  }

}
