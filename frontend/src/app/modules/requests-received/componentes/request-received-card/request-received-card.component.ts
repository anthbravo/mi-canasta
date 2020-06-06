import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-request-received-card',
  templateUrl: './request-received-card.component.html',
  styleUrls: ['./request-received-card.component.scss']
})
export class RequestReceivedCardComponent implements OnInit {

  @Input()
  request:any;

  constructor() { }

  ngOnInit(): void {
  }

}
