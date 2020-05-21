import { environment } from './../../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/request/user.model';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private httpClient: HttpClient) {}

  async createUser(user: User) {
    console.log('createUser');
    return await this.httpClient.post<User>(`${environment.url_api}/usuarios`, user).toPromise();
  }
}
