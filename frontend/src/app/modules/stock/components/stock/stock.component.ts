import { Component, OnInit } from '@angular/core';
import { StockGet } from 'src/app/core/model/stock.model';
import { AuthService } from 'src/app/core/service/auth.service';
import { RolService } from 'src/app/core/service/rol.service';
import { TiendaService } from 'src/app/core/service/tienda.service';
import { HomeService } from 'src/app/core/service/home.service';
import { RolPorUsuario } from 'src/app/core/model/rol.model';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.scss']
})
export class StockComponent implements OnInit {

  stocks: StockGet[] = [];
  roles: RolPorUsuario[] = [];
  loadingButton: boolean = false;
  stocksUpdate: StockGet[] = [];
  flagModal: boolean = false;
  flagAdmin: boolean = true;

  constructor(
    private authService: AuthService,
    private rolService: RolService,
    private tiendaService: TiendaService,
    private homeService: HomeService
  ) { }

  ngOnInit(){
    this.homeService.setStatus({ isLoginView: false });
    this.getRoles();
    this.getStocksFirst();
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

  async getRoles(){
    const res = await this.rolService.getRol(this.authService.getUsuarioAutenticacion().usuario.dni);
    this.roles = res;
    console.log(this.roles);
    this.isAdmin();
  }

  isAdmin(){
    for(let i = 0; this.roles.length; i++){
      if(this.roles[i].rolPerfilId == 3){
        this.flagAdmin = false; 
      }
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

  async putStock(i: number){
    try {
        if(this.stocks[i].cantidad != this.stocksUpdate[i].cantidad){
            await this.tiendaService.putStock(this.stocks[i].tiendaId,
            this.stocks[i].productoId, {
              cantidad: this.stocksUpdate[i].cantidad
            });
        }
    }
    catch (error) {
        console.log(error);        
    }
  }

  async actualizarStock(){
    await this.getStocksSecond();
    this.loadingButton = true;
    for(let i = 0; i < this.stocksUpdate.length; i++){
        this.putStock(i);
    }
    this.loadingButton = false;
    this.flagModal = true;
  }

  cerrarModal(){
    this.flagModal = false;
  }
}
