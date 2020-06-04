import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-card-request',
  templateUrl: './card-request.component.html',
  styleUrls: ['./card-request.component.scss']
})
export class CardRequestComponent implements OnInit {
  @Input()
  request:any;

  constructor() { }

  ngOnInit(): void {
  }

}
