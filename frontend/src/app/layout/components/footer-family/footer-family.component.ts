import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/core/service/auth.service';

@Component({
  selector: 'app-footer-family',
  templateUrl: './footer-family.component.html',
  styleUrls: ['./footer-family.component.scss'],
})
export class FooterFamilyComponent implements OnInit {
  activedIndex = 2;

  constructor(private router: Router, private authService: AuthService) {}

  ngOnInit(): void {}

  onSelecteFooterIcon(index) {
    if (index === 1) {
      this.activedIndex = 1;
      this.router.navigate(['family/map']);
    } else if (index === 2) {
      this.activedIndex = 2;
      this.router.navigate([
        'family/members/' +
          this.authService.getUsuarioAutenticacion().familia.id,
      ]);
    } else if (index === 3) {
      this.activedIndex = 3;
      this.router.navigate(['family/limit']);
    } else if (index === 4) {
      this.activedIndex = 4;
      this.router.navigate(['family/account']);
    }
  }
}
