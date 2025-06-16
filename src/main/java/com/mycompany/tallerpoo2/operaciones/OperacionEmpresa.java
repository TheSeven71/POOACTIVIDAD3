/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.tallerpoo2.operaciones;


import  com.mycompany.tallerpoo2.modelos.Empresa;

import java.util.ArrayList;
import java.util.List;

public class OperacionEmpresa implements IOperacionEmpresa {

    private List<Empresa> empresas;

    public OperacionEmpresa() {
        empresas = new ArrayList<>();
    }

    @Override
    public void agregarEmpresa(Empresa empresa) {
        empresas.add(empresa);
    }

    @Override
    public Empresa buscarEmpresa(String nit) {
        for (Empresa e : empresas) {
            if (e.getNit().equals(nit)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Empresa> listarEmpresas() {
        return empresas;
    }
}
