/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.tallerpoo2.operaciones;


import com.mycompany.tallerpoo2.modelos.Empleado;
import com.mycompany.tallerpoo2.modelos.Empresa;

import java.util.List;

public interface IOperacionEmpleado {
    void agregarEmpleado(Empleado empleado);
    Empleado buscarPorDocumento(String documento);
    List<Empleado> listarEmpleados();
    double calcularSueldo(String documento, int horasTrabajadas);
    int contarPorEmpresa(Empresa empresa);
}