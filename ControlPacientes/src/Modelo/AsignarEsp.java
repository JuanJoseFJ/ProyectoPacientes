/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Medico;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author CRISTIAN
 */
public class AsignarEsp {
    
    public String AgregarEspecialidad(String cod, String especialidad) {
        Conexion nconexion = new Conexion();  //objeto de la clase conexion
        Connection conex; 
       
        try
        {
            nconexion.Conectar(); // ejecuta el metodo conectar de la clase conexion el que contiene la direccion de la base de datos 
            conex = nconexion.getConexion();  //aca se retorna la conexion que se obtuvo
            Statement comando = conex.createStatement(); //comando para poder ejecutar executeUpdate
            
            //EJECUTAR LA CONSULTA DE INSERCION
            
            comando.executeUpdate("insert into especialidades() values('0','"+cod+"','"+especialidad+"')");
    
            conex.close();
            return "Especialidad agregada exitosamente";
        
        }
        
        catch(Exception e)
        {
            
            return "Ha ocurrido un error al agregar una especialidad "+e;
        }
    
    }
    
    public String AsignarEspecialidad(String codDoc, String especialidad) {
        Conexion nconexion = new Conexion();  //objeto de la clase conexion
        Connection conex; 
       
        try
        {
            nconexion.Conectar(); // ejecuta el metodo conectar de la clase conexion el que contiene la direccion de la base de datos 
            conex = nconexion.getConexion();  //aca se retorna la conexion que se obtuvo
            Statement comando = conex.createStatement(); //comando para poder ejecutar executeUpdate
            String idEspecialidad="";
            ResultSet consulta = comando.executeQuery("select especialidades.idEspecialidad from especialidades where especialidades.Especialidad='"+especialidad+"'");
        
           
            while(consulta.next()==true )
               
            {
                idEspecialidad=consulta.getString("idEspecialidad");

                 
                        
            }
            //EJECUTAR LA CONSULTA DE INSERCION
            
            
            comando.executeUpdate("insert into asignacionespecialidad() values('0','"+codDoc+"','"+idEspecialidad+"')");
            
            conex.close();
            return "Especialidad agregada exitosamente";
        
        }
        
        catch(Exception e)
        {
            
            return "Ha ocurrido un error al agregar una Especialidad: "+e;
        }
    
    }
    
}
