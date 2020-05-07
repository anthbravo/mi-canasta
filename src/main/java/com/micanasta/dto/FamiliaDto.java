package com.micanasta.dto;

public class FamiliaDto {


    private long id;
    private String nombreUnico;
    private boolean aceptacionSolicitudes;
    private int cantidad;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreUnico() {
        return nombreUnico;
    }

    public void setNombreUnico(String nombreUnico) {
        this.nombreUnico = nombreUnico;
    }

    public boolean isAceptacionSolicitudes() {
        return aceptacionSolicitudes;
    }

    public void setAceptacionSolicitudes(boolean aceptacionSolicitudes) {
        this.aceptacionSolicitudes = aceptacionSolicitudes;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
