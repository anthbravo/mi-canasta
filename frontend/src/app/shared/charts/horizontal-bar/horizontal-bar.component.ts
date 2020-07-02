import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-horizontal-bar',
  templateUrl: './horizontal-bar.component.html',
  styleUrls: ['./horizontal-bar.component.scss']
})
export class HorizontalBarComponent implements OnInit {

    @Input()
    cards:any[]

    total = 0;
  constructor() { }

  ngOnInit(): void {
      this.calculateTotal();
  }

  calculateTotal(){
    const reduce = (acc, item) => {
        return acc + item.value;
      };

      this.total = this.cards.reduce(reduce, 0);
  }

}