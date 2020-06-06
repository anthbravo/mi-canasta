import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/core/service/home.service';

@Component({
  selector: 'app-requests-received',
  templateUrl: './requests-received.component.html',
  styleUrls: ['./requests-received.component.scss'],
})
export class RequestsReceivedComponent implements OnInit {
  switchValue = false;
  mock = [
    { title: 'Solicitud 10', nombre: 'Felipe Gomez', dni: '73044851' },
    { title: 'Solicitud 10', nombre: 'Felipe Gomez', dni: '73044851' },
    { title: 'Solicitud 10', nombre: 'Felipe Gomez', dni: '73044851' },
    { title: 'Solicitud 10', nombre: 'Felipe Gomez', dni: '73044851' },
  ];
  constructor(private homeService: HomeService) {}

  ngOnInit(): void {
    this.homeService.setStatus({ isLoginView: false });
  }
}
