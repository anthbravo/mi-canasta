import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-limit-category',
  templateUrl: './limit-category.component.html',
  styleUrls: ['./limit-category.component.scss']
})
export class LimitCategoryComponent implements OnInit {

  @Input()
  limite: any;

  @Input()
  restante: any;

  @Input()
  descripcion: string;

  dataHorizontalBar: any[];

  constructor() { }

  ngOnInit(): void {
    console.log("HOla");
    console.log(this.restante);
    console.log(this.descripcion);
    this.definirData();
  }

  definirData(){
    this.dataHorizontalBar = [
      {text: this.restante, color: "red", value: 2},
      {text: "0", color: "orange", value: 1},
    ]
  }

}
