import { Component, OnInit, Input } from '@angular/core';
import { StockGet } from 'src/app/core/model/stock.model';
import { ProductoGet } from 'src/app/core/model/producto.model';
import { ProductoService } from 'src/app/core/service/producto.service';
import { CategoriaService } from 'src/app/core/service/categoria.service';

@Component({
  selector: 'app-stock-product',
  templateUrl: './stock-product.component.html',
  styleUrls: ['./stock-product.component.scss']
})

export class StockProductComponent implements OnInit {

  @Input()
  stockUpdate:StockGet;

  producto: ProductoGet;
  unidad:string = "";
  loaded:boolean = false;

  constructor(
    private productoService: ProductoService,
    private categoriaService: CategoriaService,
  ) { }

  ngOnInit(): void {
    this.getProducto();
  }

  async getProducto(){
    try {
        const res = await this.productoService.getProducto(this.stockUpdate.productoId);
        this.producto = res;
        this.getCategoria();
    }
    catch (error) {
        console.log(error);        
    }   
  }

  async getCategoria(){
    try {
        const res = await this.categoriaService.getCategoria(this.producto.categoriaId);
        this.unidad = res.tipoDeUnidad;
        this.loaded = true;
    }
    catch (error) {
        console.log(error);        
    }
  }
}
