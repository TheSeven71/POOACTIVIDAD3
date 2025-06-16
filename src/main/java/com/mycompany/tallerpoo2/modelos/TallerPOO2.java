/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tallerpoo2.modelos;
import com.mycompany.tallerpoo2.operaciones.*;
import java.util.Scanner;

/**
 *
 * @author finan
 */
public class TallerPOO2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IOperacionEmpresa opEmpresa = new OperacionEmpresa();
        IOperacionEmpleado opEmpleado = new OperacionEmpleado();

        int opcion = -1;
        while (opcion != 0) {
            try {
                System.out.println("\n========= MENU PRINCIPAL =========");
                System.out.println("1. Registrar una empresa");
                System.out.println("2. Registrar un empleado");
                System.out.println("3. Ver todas las empresas");
                System.out.println("4. Ver todos los empleados");
                System.out.println("5. Buscar empleado por documento");
                System.out.println("6. Calcular sueldo de un empleado");
                System.out.println("7. Ver cuantos empleados tiene una empresa");
                System.out.println("0. Salir");
                System.out.print("Elige una opcion: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Por favor ingresa un numero valido.");
                    sc.nextLine(); // limpiar
                    continue;
                }
                opcion = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1 -> {
                        System.out.print("NIT: ");
                        String nit = sc.nextLine().trim();
                        System.out.print("Nombre de la empresa: ");
                        String nombre = sc.nextLine().trim();
                        System.out.print("Direccion: ");
                        String direccion = sc.nextLine().trim();
                        System.out.print("Ciudad: ");
                        String ciudad = sc.nextLine().trim();

                        if (nit.isEmpty() || nombre.isEmpty()) {
                            System.out.println("El NIT y el nombre son obligatorios.");
                            break;
                        }

                        Empresa empresa = new Empresa(nit, nombre, direccion, ciudad);
                        opEmpresa.agregarEmpresa(empresa);
                        System.out.println("Empresa registrada con exito.");
                    }

                    case 2 -> {
                        System.out.print("Tipo de documento: ");
                        String tipoDoc = sc.nextLine().trim();
                        System.out.print("Documento: ");
                        String documento = sc.nextLine().trim();
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine().trim();

                        System.out.print("Sueldo por hora: ");
                        if (!sc.hasNextDouble()) {
                            System.out.println("Sueldo debe ser un numero.");
                            sc.nextLine();
                            break;
                        }
                        double sueldoHora = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("NIT de la empresa: ");
                        String nitEmpresa = sc.nextLine().trim();
                        Empresa empresa = opEmpresa.buscarEmpresa(nitEmpresa);

                        if (empresa == null) {
                            System.out.println("Empresa no encontrada.");
                            break;
                        }

                        System.out.println("Tipo de empleado:");
                        System.out.println("1. Desarrollador");
                        System.out.println("2. Gestor de Proyectos");
                        System.out.println("3. Admin");

                        if (!sc.hasNextInt()) {
                            System.out.println("Debes escribir un numero (1, 2 o 3).");
                            sc.nextLine();
                            break;
                        }
                        int tipo = sc.nextInt();
                        sc.nextLine();

                        Empleado empleado = null;
                        switch (tipo) {
                            case 1 -> empleado = new Desarrollador(tipoDoc, documento, nombre, sueldoHora, empresa);
                            case 2 -> {
                                System.out.print("Area del gestor: ");
                                String area = sc.nextLine().trim();
                                empleado = new GestorProyectos(tipoDoc, documento, nombre, sueldoHora, empresa, area);
                            }
                            case 3 -> empleado = new Admin(tipoDoc, documento, nombre, sueldoHora, empresa);
                            default -> {
                                System.out.println("Opcion no valida para tipo de empleado.");
                                continue;
                            }
                        }

                        opEmpleado.agregarEmpleado(empleado);
                        System.out.println("Empleado registrado con exito.");
                    }

                    case 3 -> {
                        var empresas = opEmpresa.listarEmpresas();
                        if (empresas.isEmpty()) {
                            System.out.println("No hay empresas registradas.");
                        } else {
                            System.out.println("\n--- Empresas ---");
                            for (Empresa e : empresas) {
                                System.out.println(e);
                            }
                        }
                    }

                    case 4 -> {
                        var empleados = opEmpleado.listarEmpleados();
                        if (empleados.isEmpty()) {
                            System.out.println("No hay empleados registrados.");
                        } else {
                            System.out.println("\n--- Empleados ---");
                            for (Empleado e : empleados) {
                                System.out.println(e);
                            }
                        }
                    }

                    case 5 -> {
                        System.out.print("Documento del empleado: ");
                        String doc = sc.nextLine().trim();
                        Empleado e = opEmpleado.buscarPorDocumento(doc);
                        if (e != null) {
                            System.out.println("Empleado encontrado:\n" + e);
                        } else {
                            System.out.println("No se encontro ningun empleado con ese documento.");
                        }
                    }

                    case 6 -> {
                        System.out.print("Documento del empleado: ");
                        String doc = sc.nextLine().trim();
                        System.out.print("Horas trabajadas: ");
                        if (!sc.hasNextInt()) {
                            System.out.println("Debes ingresar un numero entero para las horas.");
                            sc.nextLine();
                            break;
                        }
                        int horas = sc.nextInt();
                        sc.nextLine();
                        double sueldo = opEmpleado.calcularSueldo(doc, horas);
                        System.out.println("Sueldo calculado: $" + sueldo);
                    }

                    case 7 -> {
                        System.out.print("NIT de la empresa: ");
                        String nit = sc.nextLine().trim();
                        Empresa empresa = opEmpresa.buscarEmpresa(nit);
                        if (empresa != null) {
                            int cantidad = opEmpleado.contarPorEmpresa(empresa);
                            System.out.println("La empresa tiene " + cantidad + " empleados.");
                        } else {
                            System.out.println("No se encontro esa empresa.");
                        }
                    }

                    case 0 -> System.out.println("Gracias por usar el sistema!");

                    default -> System.out.println("Opcion no valida. Intenta otra vez.");
                }

            } catch (Exception e) {
                System.out.println("Ocurrio un error inesperado. Intenta de nuevo.");
                sc.nextLine(); // limpiar por si acaso
            }
        }

        sc.close();
    }
}