import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-solicitud',
  templateUrl: './solicitud.component.html',
  styleUrls: ['./solicitud.component.scss']
})
export class SolicitudComponent implements OnInit {

  constructor( private route: Router) {
  }

  ngOnInit(): void {
  }
  async volverAInicio(){
    this.route.navigate(['/home']);
  }
}
