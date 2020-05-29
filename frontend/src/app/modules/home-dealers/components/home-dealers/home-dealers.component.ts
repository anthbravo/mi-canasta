import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/core/service/home.service';

@Component({
  selector: 'app-home-dealers',
  templateUrl: './home-dealers.component.html',
  styleUrls: ['./home-dealers.component.scss']
})
export class HomeDealersComponent implements OnInit {
  switchValue = false;
  mock= [
    {
      name: 'Anthony',
      dni: '10101010',
      roles: ['Admin', 'Comprador'],
      categorias: ['Mercancia'],
    },
    {
      name: 'Jimena',
      dni: '1245789',
      roles: ['Comprador'],
      categorias: ['Alimentos']
    }
  ];
  constructor(private homeService:HomeService) { }

  ngOnInit(): void {
    this.homeService.setStatus({ isLoginView: false });

  }

}
