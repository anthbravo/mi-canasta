import { environment } from './../../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private httpClient: HttpClient) {}

  createUser(user: User) {
    console.log('createUser');
    return this.httpClient.post<User>(`${environment.url_api}/users`, user);
  }
}
