package com.pcbuilder.builder;

import com.pcbuilder.model.Computadora;

public class ComputadoraBuilder {

    private String procesador;
    private String ram;
    private String disco;
    private String tarjetaGrafica;
    private String sistemaOperativo;

    public ComputadoraBuilder setProcesador(String procesador) {
        this.procesador = procesador;
        return this;
    }

    public ComputadoraBuilder setRam(String ram) {
        this.ram = ram;
        return this;
    }

    public ComputadoraBuilder setDisco(String disco) {
        this.disco = disco;
        return this;
    }

    public ComputadoraBuilder setTarjetaGrafica(String tarjetaGrafica) {
        this.tarjetaGrafica = tarjetaGrafica;
        return this;
    }

    public ComputadoraBuilder setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
        return this;
    }

    public Computadora build() {
        return new Computadora(procesador, ram, disco, tarjetaGrafica, sistemaOperativo);
    }
}