/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoagendamysql;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author CDMFP
 */
class EntradaSalida {
final static int INSERTAR=1;
final static int LISTAR=2;
final static int BUSCAR=3;
final static int SALIR=5;
final static int ACTUALIZAR=4;
final static int MODIFICAR_NOMBRE=1;
final static int MODIFICAR_TELEFONO=2;

    static int pedirOpcion() {
        
        System.out.println(INSERTAR+"-Insertar contacto");
        System.out.println(LISTAR+"-Listar contactos");
        System.out.println(BUSCAR+"-Buscar contacto por nombre");
        System.out.println(ACTUALIZAR+"-Actualizar contacto");
        System.out.println(SALIR+"-Salir");
        Scanner sc=new Scanner(System.in);
        int opcion=sc.nextInt();
        return opcion;
    }

    static Contacto pedirContacto() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nombre: ");
        String nombre=sc.nextLine();
        System.out.println("Teléfono:");
        String telefono=sc.nextLine();
       Contacto c=new Contacto(nombre, telefono);
        return c;
    }

    static void mostrarContactos(ArrayList<Contacto> lista_contactos) {
        for (Contacto contacto : lista_contactos) {
            System.out.println(contacto);
        }
    }

    static String pedirNombre() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nombre buscado: ");
        String nombre=sc.nextLine();
        return nombre;
    }

    static int pedirIdModificacion(ArrayList<Contacto> lista_contactos_actualizar) {
        System.out.println("Introduzca el id que quiera modificar:");
        mostrarContactos(lista_contactos_actualizar);
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        return n;
    }

    static int campoModificar() {
        System.out.println(MODIFICAR_NOMBRE+"Modificar nombre");
        System.out.println(MODIFICAR_TELEFONO+"Modificar teléfono");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        return n;
    }

    static String pedirNuevoNombre() {
       Scanner sc=new Scanner(System.in);
        System.out.println("Introduzca el nuevo nombre: ");
        String nombre=sc.nextLine();
        return nombre;
        
    }

    static String pedirNuevoTelefono() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduzca el nuevo teléfono ");
        String telefono=sc.nextLine();
        return telefono;
    }
    
}
