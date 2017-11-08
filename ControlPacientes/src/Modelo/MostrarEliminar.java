package Modelo;

import Vistas.JDeliminarPaciente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MostrarEliminar {
    public String Mostrarpacientes(DefaultTableModel Modelo,String apellido){
       Conexion nuevaConexion = new Conexion();
        Connection conex;
        ResultSet Consulta = null;
        try {
          nuevaConexion.Conectar();
          conex = nuevaConexion.getConexion();
            Statement comando = conex.createStatement();
           
            Consulta = comando.executeQuery("select pacientes.idPaciente, pacientes.Nombre, pacientes.Apellidos, pacientes.DIreccion, pacientes.Telefono from pacientes where pacientes.Apellidos='"+apellido+"'");
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
              JDeliminarPaciente.JTdatosPaciente.setModel(Modelo);
              return"tabla llena";
            }
           
      } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error"+ e);
            return "error";
      }
  }
}
