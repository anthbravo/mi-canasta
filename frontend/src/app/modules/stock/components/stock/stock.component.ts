import { Component, OnInit } from '@angular/core';
import { TiendaService } from 'src/app/core/service/tienda.service';
import { StockGet } from 'src/app/core/model/stock.model';
import { AuthService } from 'src/app/core/service/auth.service';
import { HomeService } from 'src/app/core/service/home.service';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.scss']
})
export class StockComponent implements OnInit {

  stocks: StockGet[] = [];
  loadingButton: boolean = false;
  stocksUpdate: StockGet[] = [];
  flagModal: boolean = false;
  flagAdmin: boolean = true;

  constructor(
    private tiendaService: TiendaService,
    private authService: AuthService,
    private homeService: HomeService
  ) { }

  ngOnInit(): void {
    this.homeService.setStatus({ isLoginView: false });
    this.getStocksFirst();
    //this.isAdmin();
  }

  async getStocksFirst(){
    try {
      const res = await this.tiendaService.getStocks(this.authService.getUsuarioAutenticacion().tienda.id);
      this.stocksUpdate = res;
    }
    catch (error) {
      console.log(error);        
    }
  }

  async getStocksSecond(){
    try {
        const res = await this.tiendaService.getStocks(this.authService.getUsuarioAutenticacion().tienda.id);
        this.stocks = res;
    }
    catch (error) {
        console.log(error);        
    }
  }

  actualizarStock(){}
  cerrarModal(){}

}
