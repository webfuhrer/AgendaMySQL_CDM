/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoagendamysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CDMFP
 */
public class AccesoDatos {
private static Connection conexion=null;
private static Statement stmt=null;
public static void inicializarBD()
{
    try {
        conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda_clase",
                "root", "");
        stmt= conexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    static void insertarContacto(Contacto c) {
        try {
             
            String nombre=c.getNombre();
            String telefono=c.getTelefono();
            String sql="INSERT INTO t_contactos(nombre, telefono) values ('"+nombre+"', '"+telefono+"')";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static ArrayList<Contacto> recuperarContactos(String nombre_buscado) {
        ArrayList<Contacto> lista=new ArrayList<>();
        try {
            
            String query="SELECT * FROM t_contactos";
            if (nombre_buscado!="")
            {
                query +=" WHERE nombre='"+nombre_buscado+"'";
            }
            
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                String nombre=rs.getString("nombre");
                String telefono=rs.getString("telefono");
                int id=rs.getInt("id");
                Contacto c=new Contacto(nombre, telefono, id);
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    static void actualizarNombre(int id, String nuevo_nombre) {
       String query="UPDATE t_contactos SET nombre='"+nuevo_nombre+"' WHERE id="+id;
    try {
        stmt.executeUpdate(query);
    } catch (SQLException ex) {
        Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
    }
    }


    static void actualizarTelefono(int id, String nuevo_telefono) {
       String query="UPDATE t_contactos SET telefono='"+nuevo_telefono+"' WHERE id="+id;
       try {
        stmt.executeUpdate(query);
    } catch (SQLException ex) {
        Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
}
