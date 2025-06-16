/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo2.modelos;

/**
 *
 * @author finan
 */

public abstract class Empleado {
    private String tipoDocumento;
    private String documento;
    private String nombre;
    private double sueldoHora;
    private Empresa empresa;

    public Empleado() {}

    public Empleado(String tipoDocumento, String documento, String nombre, double sueldoHora, Empresa empresa) {
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.nombre = nombre;
        this.sueldoHora = sueldoHora;
        this.empresa = empresa;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoHora() {
        return sueldoHora;
    }

    public void setSueldoHora(double sueldoHora) {
        this.sueldoHora = sueldoHora;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "tipoDocumento='" + tipoDocumento + '\'' +
                ", documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", sueldoHora=" + sueldoHora +
                ", empresa=" + (empresa != null ? empresa.getNombre() : "Sin empresa") +
                '}';
    }
}
