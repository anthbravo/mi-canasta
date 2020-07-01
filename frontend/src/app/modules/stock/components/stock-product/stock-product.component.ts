import { Component, OnInit, Input } from '@angular/core';
import { ProductoGet } from 'src/app/core/model/Producto.model';
import { ProductoService } from 'src/app/core/service/producto.service';
import { CategoriaService } from 'src/app/core/service/categoria.service';
import { StockGet } from 'src/app/core/model/stock.model';

@Component({
  selector: 'app-stock-product',
  templateUrl: './stock-product.component.html',
  styleUrls: ['./stock-product.component.scss']
})
export class StockProductComponent implements OnInit {

  @Input()
  stockUpdate: StockGet;

  producto: ProductoGet;
  unidad: string;
  visible: boolean = false;

  constructor(
    private productoService: ProductoService,
    private categoriaService: CategoriaService
  ) { }

  ngOnInit(): void {
    this.getProducto();
  }

  async getProducto(){
    try {
        const res = await this.productoService.getProducto(this.stockUpdate.productoId);
        this.producto = res;
        this.getCategoria();
        this.visible = true;
    }
    catch (error) {
        console.log(error);        
    }
  }

  async getCategoria(){
    try {
        const res = await this.categoriaService.getCategoria(this.producto.categoriaId);
        this.unidad = res.tipoDeUnidad;
    }
    catch (error) {
        console.log(error);        
    }
  }
}
