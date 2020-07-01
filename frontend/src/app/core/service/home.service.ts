import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class HomeService {
  pageStatus = new BehaviorSubject<any>({ isLoginView: true });
  roleUser  = new BehaviorSubject<any>({role: localStorage.getItem("role")})
  constructor() {}

  setStatus(item: any) {
    this.pageStatus.next(item);
  }

  setRoleStatus(item){
    this.roleUser.next(item);
  }
}
