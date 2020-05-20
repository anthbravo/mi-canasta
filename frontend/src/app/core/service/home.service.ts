import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  pageStatus =  new BehaviorSubject<any>({isLoginView:true})

  constructor() { }

  setStatus(item:any){
    this.pageStatus.next(item)
  }

}
