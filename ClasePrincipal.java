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
                    ArrayList<Contacto> lista_contactos=AccesoDatos.recuperarContactos();
                    //System.out.println(lista_contactos);
                    EntradaSalida.mostrarContactos(lista_contactos);
                    break;
            }
            opcion=EntradaSalida.pedirOpcion();
        }
    }
}
