import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/core/service/home.service';
import { NzMarks } from 'ng-zorro-antd/slider/typings';

@Component({
  selector: 'app-sale-page',
  templateUrl: './sale-page.component.html',
  styleUrls: ['./sale-page.component.scss']
})
export class SalePageComponent implements OnInit {
  inputValue =  0
  inputValue1 = 1
  nombre  = "Jair Huaman Bellido"
  dni = "78451234"
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

  setLimitsLegend(item){
    let a:NzMarks = {};
    a[item.minValue] =  item.minValue+ "";
    a[item.maxValue] =  item.maxValue+ "";
    return a;
  }

}
