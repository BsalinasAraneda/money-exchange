package com.practice.apiexchange.models;

import com.practice.apiexchange.DTOs.ExancheAPI;

public class Moneda {
    private String monedaOrigen;
    private String monedaDestino;
    private String fechaUltimaActualizacion;
    private double valorMonedaActual;
    private double valorFinalConversion;

    public Moneda(ExancheAPI exancheAPI){
        this.monedaOrigen = exancheAPI.base_code();
        this.monedaDestino = exancheAPI.target_code();
        this.fechaUltimaActualizacion = exancheAPI.time_last_update_utc();
        this.valorMonedaActual = exancheAPI.conversion_rate();
        this.valorFinalConversion = exancheAPI.conversion_result();
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public String getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public double getValorMonedaActual() {
        return valorMonedaActual;
    }

    public double getValorFinalConversion() {
        return valorFinalConversion;
    }

    @Override
    public String toString() {
        return  "*** Datos Convervion ***" + "\n"+
                " Moneda origen: " + monedaOrigen + "\n"+
                " Moneda destino: " + monedaDestino + "\n"+
                " Fecha ultima actualizacion: " + fechaUltimaActualizacion + "\n"+
                " Valor actual mercado: " + valorMonedaActual + "\n"+
                " Valor final conversion: " + valorFinalConversion + "\n";
    }
}
