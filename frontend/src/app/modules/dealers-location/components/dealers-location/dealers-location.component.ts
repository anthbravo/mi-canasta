import { Component, OnInit, ViewChild } from '@angular/core';
import { HomeService } from 'src/app/core/service/home.service';

@Component({
    selector: 'app-dealers-location',
    templateUrl: './dealers-location.component.html',
    styleUrls: ['./dealers-location.component.scss'],
})
export class DealersLocationComponent implements OnInit {
    lat = -12.063857;
    lng = -77.035029;
    selectedMarker;
    kioskoMarkers = [
        { lat: -12.063437, lng: -77.039903, alpha: 1 },
        { lat: -12.06457, lng: -77.040104, alpha: 1 },
    ];

    tiendaMarkers = [
        { lat: -12.095683, lng: -76.997026, alpha: 1 },
        { lat: -12.099292, lng: -76.999054, alpha: 1 },
        { lat: -12.099093, lng: -76.999226, alpha: 1 },
    ];

    emergenciaMarkers = [
        { lat: -12.127908, lng: -77.020861, alpha: 1 },
        { lat: -12.128988, lng: -77.024208, alpha: 1 },
        { lat: -12.128988, lng: -77.024208, alpha: 1 },
    ];
    markers = [
        // These are all just random coordinates from https://www.random.org/geographic-coordinates/
    ];
    actualFilterSelected = 0;
    filterOptionsMap = [
        {
            name: 'Kiosko',
            iconActivate: 'assets/stand_activate.svg',
            iconDesactivate: 'assets/stand_desactivate.svg',
        },
        {
            name: 'Tienda',
            iconActivate: 'assets/shop_activate.svg',
            iconDesactivate: 'assets/shop_desactivate.svg',
        },
        {
            name: 'Hospital',
            iconActivate: 'assets/hospital_activate.svg',
            iconDesactivate: 'assets/hospital_desactivate.svg',
        },
    ];

    constructor(private homeService: HomeService) {}
    ngOnInit() {
        this.homeService.setStatus({ isLoginView: false });

        this.markers = this.kioskoMarkers;
    }

    addMarker(lat: number, lng: number) {
        this.markers.push({ lat, lng, alpha: 0.4 });
    }

    max(coordType: 'lat' | 'lng'): number {
        return Math.max(...this.markers.map((marker) => marker[coordType]));
    }

    min(coordType: 'lat' | 'lng'): number {
        return Math.min(...this.markers.map((marker) => marker[coordType]));
    }

    selectMarker(event) {
        this.selectedMarker = {
            lat: event.latitude,
            lng: event.longitude,
        };
    }

    changeOption(i) {
        this.actualFilterSelected = i;

        if(i === 0)     this.mostrarKiosos()
        else if(i===1)  this.mostrarTiendas()
        else            this.mostrarEmergencias()
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

    mostrarEmergencias() {
        this.lat = -12.126251;
        this.lng = -77.017835;
        this.markers = this.emergenciaMarkers;
    }
}
