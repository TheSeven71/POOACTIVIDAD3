/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.tallerpoo2.operaciones;

import com.mycompany.tallerpoo2.modelos.Empleado;
import com.mycompany.tallerpoo2.modelos.Empresa;

import java.util.ArrayList;
import java.util.List;

public class OperacionEmpleado implements IOperacionEmpleado {

    private List<Empleado> empleados;

    public OperacionEmpleado() {
        empleados = new ArrayList<>();
    }

    @Override
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    @Override
    public Empleado buscarPorDocumento(String documento) {
        for (Empleado e : empleados) {
            if (e.getDocumento().equals(documento)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Empleado> listarEmpleados() {
        return empleados;
    }

    @Override
    public double calcularSueldo(String documento, int horasTrabajadas) {
        Empleado e = buscarPorDocumento(documento);
        if (e != null) {
            return e.getSueldoHora() * horasTrabajadas;
        }
        return 0.0;
    }

    @Override
    public int contarPorEmpresa(Empresa empresa) {
        int count = 0;
        for (Empleado e : empleados) {
            if (e.getEmpresa().equals(empresa)) {
                count++;
            }
        }
        return count;
    }
}