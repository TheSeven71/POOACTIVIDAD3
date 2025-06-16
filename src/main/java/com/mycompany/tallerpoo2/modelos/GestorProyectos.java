/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo2.modelos;

/**
 *
 * @author finan
 */
public class GestorProyectos extends Empleado {
    private String area;

    public GestorProyectos() {
        super();
    }

    public GestorProyectos(String tipoDocumento, String documento, String nombre, double sueldoHora, Empresa empresa, String area) {
        super(tipoDocumento, documento, nombre, sueldoHora, empresa);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}