import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/core/service/home.service';
import { NzMarks } from 'ng-zorro-antd/slider/typings';
import { SharedModule } from 'src/app/shared/shared.module';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sale-page',
  templateUrl: './sale-page.component.html',
  styleUrls: ['./sale-page.component.scss']
})
export class SalePageComponent implements OnInit {
  loadingLoginButton = false;
  disableButton = false;

  inputValue =  0
  inputValue1 = 1
  nombre  = "Vivie All"
  dni = "78451234"
  products = [
    { name: "Arroz(Kg)", defaultValue: 3, minValue: 1, maxValue: 5,marks: {1:1, 5:5} },
    { name: "Legumbre(kg)", defaultValue: 1, minValue: 1, maxValue: 2, marks:{1:1,2:2}},
  ]
  marks: NzMarks = {
    0:'2',
    5:'w'
  };


  constructor(
    private route: Router,
    private homeService: HomeService
  ) {}

  ngOnInit(): void {
    this.homeService.setStatus({isLoginView:false})

  }

  setLimitsLegend(item){
    let a:NzMarks = {};
    a[item.minValue] =  item.minValue+ "";
    a[item.maxValue] =  item.maxValue+ "";
    return a;
  }

}
