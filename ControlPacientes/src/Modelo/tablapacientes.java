/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vistas.JDeditarpaciente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ferag
 */
public class tablapacientes {
  public String MostrarTablapaceintes(DefaultTableModel Modelo,String apellido){
       Conexion nuevaConexion = new Conexion();
        Connection conex;
        ResultSet Consulta = null;
        try {
          nuevaConexion.Conectar();
          conex = nuevaConexion.getConexion();
            Statement comando = conex.createStatement();
           
            Consulta = comando.executeQuery("select pacientes.idPaciente,pacientes.Nombre, pacientes.Apellidos, pacientes.DIreccion, pacientes.Telefono from pacientes where pacientes.Apellidos='"+apellido+"'");
             String pacientes[] = new String[5];
            while(Consulta.next()==true){
                pacientes[0]=Consulta.getString("idPaciente");
                  pacientes[1]=Consulta.getString("Nombre");
             pacientes[2]=Consulta.getString("Apellidos");
              pacientes[3]=Consulta.getString("DIreccion");
               pacientes[4]=Consulta.getString("Telefono");
               Modelo.addRow(pacientes);
               
            }
            
            {
              JDeditarpaciente.jtmostrarpacientes.setModel(Modelo);
              return"tabla llena";
            }
           
      } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error"+ e);
            return "error";
      }
  }  
public void bloqueartxt (){
       JDeditarpaciente.txtid.setEditable(false);
    JDeditarpaciente.txtnombre.setEditable(false);
       JDeditarpaciente.txtape.setEditable(false);
}
      public void limpiarTabla(DefaultTableModel modelo) //recibe el modelo de la tabla
    {
        int filas = modelo.getRowCount(); //para saber cuantas filas tiene la tabla hasta el momento
        for(int i=0;i<filas;i++)//colocamos "<" porque  sino borrara una fila inexistente
        {
            modelo.removeRow(0); //para que valla borrando borrando la PRIMERA linea(que en si es toda la tabla)
        }
    }   
}
