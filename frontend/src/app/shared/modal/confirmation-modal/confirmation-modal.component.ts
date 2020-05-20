import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-confirmation-modal',
  templateUrl: './confirmation-modal.component.html',
  styleUrls: ['./confirmation-modal.component.scss']
})
export class ConfirmationModalComponent implements OnInit {
  @Input()
  title:string

  @Input()
  description:string

  @Output()
  yesEvent =  new EventEmitter<any>()

  @Output()
  noEvent =  new EventEmitter<any>()

  constructor() { }

  ngOnInit(): void {
  }


  yes(){
    this.yesEvent.emit()
  }

  no(){
    this.noEvent.emit()
  }

}
