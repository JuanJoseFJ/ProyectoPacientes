/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author CRISTIAN
 */
public class LLenarCombo {
    
     public void Presentar (JComboBox esp)
    {
        Conexion nconexion = new Conexion();  //objeto de la clase conexion
        Connection conex; 
         //vector horizontal que corresponde a cada columna de la tabla
        
        
        try
        {
            nconexion.Conectar(); // ejecuta el metodo conectar de la clase conexion el que contiene la direccion de la base de datos 
            conex = nconexion.getConexion();  //aca se retorna la conexion que se obtuvo
            Statement comando = conex.createStatement(); //comando para poder ejecutar executeUpdate
            
           
         
            ResultSet consulta = comando.executeQuery("select * from especialidades");
        
            String aux=""; 
            while(consulta.next()==true )
               
            {
                aux= consulta.getString("Especialidad");
                System.out.print(aux);
                esp.addItem(aux);
            }
            conex.close(); //para cerrar en la base de datos 
            
              
           
          
            //conex.close() sirve para cerrar la conexion si se ejecuta la parte del codigo anterior 
           
        }
        
        catch(Exception e)
        {
            
            JOptionPane.showMessageDialog(null, "Especialidad no encontrada" +e); 
        }
    
}

public void LimpiarCombo(JComboBox combo) // COMPLETO 
    {
        int filas = combo.getItemCount(); // cuenta numero de filas q tiene la tabla 
        for(int i=0; i<filas; i++)
        {
            combo.removeItemAt(0);// valor fijo de 0
        }
    }
}
