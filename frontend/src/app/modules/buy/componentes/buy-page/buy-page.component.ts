import { SharedModule } from 'src/app/shared/shared.module';
import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/core/service/home.service';
import { NzMarks } from 'ng-zorro-antd/slider/typings';
import { Router } from '@angular/router';

@Component({
  selector: 'app-buy-page',
  templateUrl: './buy-page.component.html',
  styleUrls: ['./buy-page.component.scss']
})
export class BuyPageComponent implements OnInit {
  loadingLoginButton = false;

  disableButton = false;

  inputValue =  0
  inputValue1 = 1
  nombre  = "Viviana All" // user.name
  dni = "78451234" // user.dni
  products = [
    { name: "Arroz(Kg)", defaultValue: 3, minValue: 1, maxValue: 5,marks: {1:1, 5:5} },
    { name: "Lenteja(kg)", defaultValue: 1, minValue: 1, maxValue: 2, marks:{1:1,2:2}},
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

  }

  async confirmarPedido() {
    this.loadingLoginButton = true;
    this.disableButton = true;
    console.log('Confirmar Pedido');
    this.route.navigate(['/home']);

  }

  setLimitsLegend(item){
    let a:NzMarks = {};
    a[item.minValue] =  item.minValue+ "";
    a[item.maxValue] =  item.maxValue+ "";
    return a;
  }

}
