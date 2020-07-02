import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/core/service/home.service';
import { CategoriaGet } from 'src/app/core/model/categoria.model';
import { AuthService } from 'src/app/core/service/auth.service';
import { CompraGet } from 'src/app/core/model/compra.model';
import { CompraService } from 'src/app/core/service/compra.service';
import { CategoriaService } from 'src/app/core/service/categoria.service';
import { ProductoService } from 'src/app/core/service/producto.service';

@Component({
  selector: 'app-limit',
  templateUrl: './limit.component.html',
  styleUrls: ['./limit.component.scss'],
})
export class LimitComponent implements OnInit {
  categorias: CategoriaGet[] = [];
  compras: CompraGet[] = [];
  fechaInicio: Date;
  fechaFin: Date;
  visible: boolean = false;

  constructor(
    private homeService: HomeService,
    private compraService: CompraService,
    private authService: AuthService,
    private categoriaService: CategoriaService,
    private productoService: ProductoService
  ) {}

  ngOnInit(): void {
    this.homeService.setStatus({ isLoginView: false });
    this.getDates();
    this.getCategorias();
  }

  async getCategorias() {
    try {
      this.categorias = await this.categoriaService.getCategorias();
      for (let i = 0; i < this.categorias.length; i++) {
        const res2 = await this.categoriaService.getLimite(
          this.categorias[i].id
        );
        this.categorias[i].limite = res2.cantidadXPersona;
        this.categorias[i].restante = res2.cantidadXPersona;
      }
      await this.getCompras();
    } catch (error) {
      console.log(error);
    }
  }

  getDates() {
    var auxiliarDate = new Date();
    auxiliarDate.setHours(0, 0, 0, 0);

    this.fechaInicio = new Date(
      auxiliarDate.setDate(auxiliarDate.getDate() - auxiliarDate.getDay() + 1)
    );
    this.fechaFin = new Date(
      auxiliarDate.setDate(auxiliarDate.getDate() - auxiliarDate.getDay() + 7)
    );
    this.fechaFin.setHours(23, 59, 59);
  }

  async getCompras() {
    try {
      const res = await this.compraService.getCompras(
        this.authService.getUsuarioAutenticacion().familia.id,
        this.fechaInicio,
        this.fechaFin,
        this.authService.getUsuarioAutenticacion().usuario.dni
      );
      this.compras = res;
      await this.getLimiteRestante();
    } catch (error) {
      console.log(error);
    }
  }

  async getLimiteRestante() {
    try {
      for (let i = 0; i < this.compras.length; i++) {
        let idProducto = this.compras[i].productoId;
        const producto = await this.productoService.getProducto(idProducto);
        const categoria = await this.categoriaService.getCategoria(
          producto.categoriaId
        );
        for (let j = 0; j < this.categorias.length; j++) {
          if (this.categorias[j].id == categoria.id) {
            this.categorias[j].restante -=
              producto.cantidadUnit * this.compras[i].cantidad;
          }
        }
      }
      this.visible = true;
      console.log(this.categorias);
    } catch (error) {
      console.log(error);
    }
  }
}
