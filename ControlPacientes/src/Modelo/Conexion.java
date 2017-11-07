/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


//----------------------LIBRERIAS QUE SE DEBEN IMPORTAR---------------------------
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

//-------------------------------------------------------------------------------

/**
 *
 * @author alumno
 */
public class Conexion {
    
    Connection conn; //variable de conexion
    String resp; //para sabe si se conecto correctamente
    
    
    public String Conectar()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");//le pasamos el nombre del conector
            conn = DriverManager.getConnection("jdbc:mysql://localhost/controlpacientes","root","");    //solo el nombre "clinica" varia en todo caso
                                              //la direccion y que usaremos
                                                                            //usuario
                                                                                     //contraseña
                                                                      
            //JOptionPane.showMessageDialog(null, "Se conectó a la Base de Datos Clinica");  
            
            return "Se conectó a la Base de Datos"; //mensaje 
            
        }
        catch(Exception e)
        {
           //JOptionPane.showMessageDialog(null, "Ocurrio un error al momento de concectarse: "+e);             
           return "Ocurrio un error al momento de concectarse a la Base de Datos: "+e; 
        }
    }
    
    //solo para retornar la variable de coneccion 
    public Connection getConexion() //para que retorne una variable tipo CONEXION
    {
        return conn; //retornamos la variable de coneccion que se creo con anterioridad
    }
    
}
