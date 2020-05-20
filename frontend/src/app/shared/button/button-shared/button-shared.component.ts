import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-button-shared',
  templateUrl: './button-shared.component.html',
  styleUrls: ['./button-shared.component.scss']
})
export class ButtonSharedComponent implements OnInit {


  @Input()
  text :String

  @Input()
  type:String

  @Input()
  bgColor:String

  @Input()
  loading:boolean

  @Input()
  disable?:boolean

  @Output()
  event =  new EventEmitter<any>();

  constructor() { }

  ngOnInit(): void {
  }

  eventParent(){
    this.event.emit()
  }

}
