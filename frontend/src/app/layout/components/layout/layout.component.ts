import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HomeService } from 'src/app/core/service/home.service';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.scss'],
})
export class LayoutComponent implements OnInit {
  constructor(private route: Router, private homeService:HomeService) {}

  isLoginView = false;
  ngOnInit(): void {
    // console.log(this.route.url);
    // if (this.route.url.includes('login')) {
    //   this.isLoginView = true;
    // }
    // this.homeService.pageStatus.subscribe(item=>{
    //   this.isLoginView =  item.isLoginView
    // })
    // this.isLoginView =  !this.route.url.includes("login")
  }


}
