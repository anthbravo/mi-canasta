import { Injectable } from '@angular/core';
import {
    RouterStateSnapshot,
    ActivatedRouteSnapshot,
    CanActivate,
    Router,
} from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';

@Injectable({
    providedIn: 'root',
})
export class GuardService implements CanActivate {
    constructor(private router: Router, private authService: AuthService) {}

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const helper = new JwtHelperService();

        let isLogged = this.authService.isLogged();

        if (!isLogged) {
            sessionStorage.clear();
            this.router.navigate(['login']);
            return false;
        } else {

            let token = JSON.parse(
                sessionStorage.getItem(environment.TOKEN_NAME)
            );

            if (!helper.isTokenExpired(token.access_token)) {
                return true;
            } else {
                sessionStorage.clear();
                this.router.navigate(['login']);
                return false;
            }
        }
    }
}
