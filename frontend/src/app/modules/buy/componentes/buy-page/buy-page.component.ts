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
  inputValue =  0
  inputValue1 = 1
  nombre  = "Viviana All" // user.name
  dni = "78451234" // user.dni
  products = [
    { name: "Arroz(U)", defaultValue: 3, minValue: 1, maxValue: 5,marks: {1:1, 5:5} },
    { name: "Legumbre(kg)", defaultValue: 1, minValue: 1, maxValue: 2, marks:{1:1,2:2}},
  ]
  marks: NzMarks = {
    0:'2',
    5:'w'
  };
  constructor(private homeSerivec:HomeService) {

   }

  ngOnInit(): void {
    this.homeSerivec.setStatus({isLoginView:false})


  }

  async confirmarPedido() {
    console.log('Confirmar Pedido');

  }

  setLimitsLegend(item){
    let a:NzMarks = {};
    a[item.minValue] =  item.minValue+ "";
    a[item.maxValue] =  item.maxValue+ "";
    return a;
  }

}
