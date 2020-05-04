import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.scss'],
})
export class LayoutComponent implements OnInit {
  constructor(private route: Router) {}

  isLoginView = false;
  ngOnInit(): void {
    console.log(this.route.url);
    if (this.route.url.includes('login')) {
      this.isLoginView = true;
    }
  }


}
