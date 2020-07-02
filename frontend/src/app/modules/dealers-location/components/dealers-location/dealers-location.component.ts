import { Component, OnInit, ViewChild } from '@angular/core';
import { HomeService } from 'src/app/core/service/home.service';
import { TiendaService } from 'src/app/core/service/tienda.service';
import { ProductoService } from 'src/app/core/service/producto.service';
import { Observable } from 'rxjs';

@Component({
    selector: 'app-dealers-location',
    templateUrl: './dealers-location.component.html',
    styleUrls: ['./dealers-location.component.scss'],
})
export class DealersLocationComponent implements OnInit {
    lat = 1.32312;
    lng = -1.2123;
    selectedMarker;
    demoValue = 3;
    loading = true;
    kioskoIconMarker = true;
    tiendaIconMarker = true;
    kioskoMarkers = [];

    tiendaMarkers = [];

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
            name: 'Supermercado',
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

        this.listarTiendas();
        this.listarSuperMercados();

        this.listarTodasTiendas().then(() => {
            this.loading = false;
            this.markers = [...this.kioskoMarkers, ...this.tiendaMarkers];
            this.productoSeleccionado = 'Lentejas';
            this.lat =  this.kioskoMarkers[0].lat;
            this.lng =  this.kioskoMarkers[0].lng;
        });
    }

    isNotSelected(value: string): boolean {
        return this.productosSeleccionados.indexOf(value) === -1;
    }

    async listarTodasTiendas() {
        try {
            const tiendas = await this.tiendaService.listarTiendas();

            tiendas.forEach(async (tienda) => {
                if (tienda.tipo === 'bodega') {
                    this.kioskoMarkers.push({
                        lat: parseFloat(tienda.latitud),
                        lng: parseFloat(tienda.longitud),
                        alpha: 1,
                        name: tienda.descripcion,
                        tipo: tienda.tipo,
                        direccion:tienda.direccion,
                        horario: tienda.horario
                    });
                } else if (tienda.tipo === 'supermercado') {
                    this.tiendaMarkers.push({
                        lat: parseFloat(tienda.latitud),
                        lng: parseFloat(tienda.longitud),
                        alpha: 1,
                        name: tienda.descripcion,
                        tipo: tienda.tipo,
                        direccion:tienda.direccion,
                        horario: tienda.horario
                    });
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

    getPin(type:string){
        if(type === "bodega") return "assets/ic_pin.png"
        else if(type === "supermercado") return "assets/ic_pin_2.png"

    }

    getColor(type:string){
        if(type === 'bodega') return "#f76a8c"
        else if(type === 'supermercado') return "#F1B62E";
    }
}
