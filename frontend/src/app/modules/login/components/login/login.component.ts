import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/core/service/user.service';
import { User } from 'src/app/core/model/request/user.model';
import { Router } from '@angular/router';
import { HomeService } from 'src/app/core/service/home.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  user: User;

  isShowConfirmationModal = false;

  isShowErrorModal = false;

  isShowWarningModal = false;

  loadingLoginButton = false;
  constructor(
    private userService: UserService,
    private route: Router,
    private homeService: HomeService
  ) {}

  ngOnInit(): void {
    this.user = new User();
  }

  async enter() {
    this.loadingLoginButton = true;

    try {
      const res = await this.userService.createUser(this.user);

      localStorage.setItem('dni', res.dni);

      this.route.navigate(['/home']);

      this.homeService.setStatus({ isLoginView: false });
    } catch (error) {

      this.openErrorModal()

      this.loadingLoginButton = false;
    }
  }

  openErrorModal() {
    this.isShowErrorModal = true;
  }

  closeErrorModal() {
    this.isShowErrorModal = false;
  }

}
