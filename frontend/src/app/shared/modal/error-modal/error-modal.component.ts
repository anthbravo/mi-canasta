import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-error-modal',
  templateUrl: './error-modal.component.html',
  styleUrls: ['./error-modal.component.scss']
})
export class ErrorModalComponent implements OnInit {


  @Input()
  title:string

  @Input()
  description:string

  @Output()
  closeEvent = new EventEmitter<any>()

  constructor() { }

  ngOnInit(): void {
  }

  closeModal(){
    this.closeEvent.emit()
  }

}
