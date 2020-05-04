import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/core/service/user.service';
import { User } from 'src/app/core/model/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  user: User;


  isShowConfirmationModal =  false;
  isShowErrorModal =  false;
  isShowWarningModal =  false;
  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.user = new User();
  }

  enter() {
    console.log("qweqwe");
    console.log(`${this.user.dni} - ${this.user.password}`);
    this.userService.createUser(this.user).subscribe(
      (user: User) => {
        console.log(user);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  openErrorModal(){
    this.isShowErrorModal = true;
  }

  closeErrorModal(){
    this.isShowErrorModal =  false;
  }


  openModalConfirmation(){
    this.isShowConfirmationModal =  true;
  }
  confirmado(){
    console.log("Confirmado")
    this.isShowConfirmationModal =  false;
  }

  noConfirmado(){
    console.log("No confirmado")
    this.isShowConfirmationModal =  false;
  }

}
