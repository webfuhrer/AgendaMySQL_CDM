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
            String sql="INSERT INTO t_contactos values ('"+nombre+"', '"+telefono+"')";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static ArrayList<Contacto> recuperarContactos() {
        ArrayList<Contacto> lista=new ArrayList<>();
        try {
        
            String query="SELECT * FROM t_contactos";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                String nombre=rs.getString("nombre");
                String telefono=rs.getString("telefono");
                Contacto c=new Contacto(nombre, telefono);
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
}
