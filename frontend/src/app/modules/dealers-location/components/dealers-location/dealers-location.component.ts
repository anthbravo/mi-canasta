import { Component, OnInit, ViewChild } from '@angular/core';
import { HomeService } from 'src/app/core/service/home.service';
import { TiendaService } from 'src/app/core/service/tienda.service';
import { ProductoService } from 'src/app/core/service/producto.service';

@Component({
    selector: 'app-dealers-location',
    templateUrl: './dealers-location.component.html',
    styleUrls: ['./dealers-location.component.scss'],
})
export class DealersLocationComponent implements OnInit {
    lat = -12.063857;
    lng = -77.035029;
    selectedMarker;
    demoValue = 3;

    kioskoIconMarker = true;
    tiendaIconMarker = true;
    kioskoMarkers = [
        { lat: -12.063437, lng: -77.039903, alpha: 1 },
        { lat: -12.06457, lng: -77.040104, alpha: 1 },
    ];

    tiendaMarkers = [
        { lat: -12.095683, lng: -76.997026, alpha: 1 },
        { lat: -12.099292, lng: -76.999054, alpha: 1 },
        { lat: -12.099093, lng: -76.999226, alpha: 1 },
    ];

    productos = [];

    productoSeleccionado = null;

    productosSeleccionados = [];

    cantidadProducto = null;

    tiendas = [];

    superMercados = [];

    markers = [];

    maxQuantity = 20;

    actualFilterSelected = 0;

    filterOptionsMap = [
        {
            name: 'Kiosko',
            iconActivate: 'assets/stand_activate.svg',
            iconDesactivate: 'assets/stand_desactivate.svg',
            flag: this.kioskoIconMarker,
            arr: this.kioskoMarkers,
        },
        {
            name: 'Tienda',
            iconActivate: 'assets/shop_activate.svg',
            iconDesactivate: 'assets/shop_desactivate.svg',
            flag: this.tiendaIconMarker,
            arr: this.tiendaMarkers,
        },
    ];

    constructor(
        private homeService: HomeService,
        private tiendaService: TiendaService,
        private productoService: ProductoService
    ) {}
    ngOnInit() {
        this.homeService.setStatus({ isLoginView: false });

        this.markers = [...this.kioskoMarkers, ...this.tiendaMarkers];
        this.listarTiendas();
        this.listarSuperMercados();

        this.listarTodasTiendas();
    }

    isNotSelected(value: string): boolean {
        return this.productosSeleccionados.indexOf(value) === -1;
    }

    async listarTodasTiendas() {
        try {
            const tiendas = await this.tiendaService.listarTiendas();
            tiendas.forEach(async (tienda) => {
                try {
                    const stocks = await this.tiendaService.listarStock(
                        tienda.id
                    );
                    stocks.forEach((stock) => {
                        stock.forEach(async (e) => {
                            try {
                                const res = await this.productoService.listarDetalleProducto(
                                    e.productoId
                                );

                                if (
                                    this.productos.filter(
                                        (e) => e.nombre === res.descripcion
                                    ).length < 1
                                ) {
                                    this.productos.push({
                                        nombre: res.descripcion,
                                        stock: e.cantidad,
                                    });
                                }
                            } catch (error) {
                                console.log('qwe');
                            }
                        });
                    });

                    console.log(this.productos);
                } catch (error) {
                    console.log(error);
                }
            });
        } catch (error) {
            console.log('error en listar tiendas', error);
        }
    }
    async listarTiendas() {
        try {
            const _tiendas = await this.tiendaService.listarTiendas();

            this.tiendas = [_tiendas[0], _tiendas[1]];
        } catch (error) {
            console.log('Hubo un error', error);
        }
    }

    async listarSuperMercados() {
        try {
            const _superMarket = await this.tiendaService.listarTiendas();

            this.superMercados = [_superMarket[2]];
        } catch (error) {
            console.log('error', error);
        }
    }

    addMarker(lat: number, lng: number) {
        this.markers.push({ lat, lng, alpha: 0.4 });
    }

    selectMarker(event) {
        this.selectedMarker = {
            lat: event.latitude,
            lng: event.longitude,
        };
    }

    changeOption(i) {
        console.log(this.markers);
        this.filterOptionsMap[i].flag = !this.filterOptionsMap[i].flag;


        let aux = this.filterOptionsMap
            .filter((e) => e.flag === true)
            .map((e) => e.arr);

        this.markers = [...aux][0] ? [...aux][0].concat([...aux][1] || []) : [];

    }

    mostrarKiosos() {
        this.lat = -12.063857;
        this.lng = -77.035029;

        this.markers = this.kioskoMarkers;
    }
    mostrarTiendas() {
        this.lat = -12.096973;
        this.lng = -76.99517;
        this.markers = this.tiendaMarkers;
    }

    changeProduct(product) {
        this.cantidadProducto = product.stock;
        this.maxQuantity = product.stock;
    }
}
