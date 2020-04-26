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

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.user = new User();
  }

  enter() {
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
}
