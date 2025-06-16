/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo2.modelos;

/**
 *
 * @author finan
 */
public class Admin extends Empleado {
    public Admin() {
        super();
    }

    public Admin(String tipoDocumento, String documento, String nombre, double sueldoHora, Empresa empresa) {
        super(tipoDocumento, documento, nombre, sueldoHora, empresa);
    }
}