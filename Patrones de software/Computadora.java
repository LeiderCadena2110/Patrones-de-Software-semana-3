package com.pcbuilder.model;

public class Computadora implements Prototype {

    private String procesador;
    private String ram;
    private String disco;
    private String tarjetaGrafica;
    private String sistemaOperativo;

    public Computadora(String procesador, String ram, String disco,
                       String tarjetaGrafica, String sistemaOperativo) {
        this.procesador = procesador;
        this.ram = ram;
        this.disco = disco;
        this.tarjetaGrafica = tarjetaGrafica;
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public Prototype clone() {
        return new Computadora(procesador, ram, disco, tarjetaGrafica, sistemaOperativo);
    }

    @Override
    public String toString() {
        return "Procesador: " + procesador +
                "\nRAM: " + ram +
                "\nDisco: " + disco +
                "\nTarjeta Gráfica: " + tarjetaGrafica +
                "\nSistema Operativo: " + sistemaOperativo;
    }
}