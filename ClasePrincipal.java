/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoagendamysql;

import java.util.ArrayList;

/**
 *
 * @author CDMFP
 */
public class ClasePrincipal {
    public static void main(String[] args) {
        int opcion=EntradaSalida.pedirOpcion();
        AccesoDatos.inicializarBD();
        while(opcion!=EntradaSalida.SALIR)
        {
            switch(opcion)
            {
                case EntradaSalida.INSERTAR:
                    //Insertar contacto
                    Contacto c=EntradaSalida.pedirContacto();
                    AccesoDatos.insertarContacto(c);
                    break;
                case EntradaSalida.LISTAR:
                    //1-Método en AccesoDatos que me devuelva un ArrayList<Contacto>
                    ArrayList<Contacto> lista_contactos=
                            AccesoDatos.recuperarContactos("");
                    //System.out.println(lista_contactos);
                    EntradaSalida.mostrarContactos(lista_contactos);
                    break;
                case EntradaSalida.BUSCAR:
                    String nombre_buscado=EntradaSalida.pedirNombre();
                    ArrayList<Contacto> lista_contactos_buscados=
                            AccesoDatos.recuperarContactos(nombre_buscado);
                     EntradaSalida.mostrarContactos(lista_contactos_buscados);
                    break;
                     case EntradaSalida.ACTUALIZAR:
                      String nombre_actualizar=EntradaSalida.pedirNombre();    
                      ArrayList<Contacto> lista_contactos_actualizar=
                            AccesoDatos.recuperarContactos(nombre_actualizar);  
                      
                       int id=EntradaSalida.pedirIdModificacion(lista_contactos_actualizar);
                       int opcion_modificar=EntradaSalida.campoModificar();
                       switch(opcion_modificar)
                       {
                           case EntradaSalida.MODIFICAR_NOMBRE:
                               //Modificar nombre
                               String nuevo_nombre=EntradaSalida.pedirNuevoNombre();
                               AccesoDatos.actualizarNombre(id, nuevo_nombre);
                               break;
                           case EntradaSalida.MODIFICAR_TELEFONO:
                               //Modificar teléfono
                                String nuevo_telefono=EntradaSalida.pedirNuevoTelefono();
                                AccesoDatos.actualizarTelefono(id, nuevo_telefono);
                               break;
                               
                               
                       }
                     break;
            }
            opcion=EntradaSalida.pedirOpcion();
        }
    }
}
