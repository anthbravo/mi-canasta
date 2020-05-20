import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {
  activedIndex = 1
  constructor() { }

  ngOnInit(): void {
  }

  onSelecteFooterIcon(index){
    this.activedIndex =  index
  }
}
