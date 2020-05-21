import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-warning-modal',
  templateUrl: './warning-modal.component.html',
  styleUrls: ['./warning-modal.component.scss']
})
export class WarningModalComponent implements OnInit {


  @Input()
  description:string

  @Output()
  closeEvent =  new EventEmitter<any>()

  constructor() { }

  ngOnInit(): void {
  }

  closeModal(){
    this.closeEvent.emit()
  }
}
