import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor() { }

  grupoFamiliar =  ''

  ngOnInit(): void {
  }

  crearGrupo(){
    console.log("Creando grupo")
  }

  unirseGrupo(){
    console.log("Unirse grupo")
  }

}
