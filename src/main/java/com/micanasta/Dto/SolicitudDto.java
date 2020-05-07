package com.micanasta.Dto;
import lombok.Setter;


public class SolicitudDto {
    private long familiaId;
    private String dni;

    public long getFamiliaId() {
        return familiaId;
    }

    public void setFamiliaId(long familiaId) {
        this.familiaId = familiaId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
