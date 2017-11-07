package Modelo;

import Vistas.JDBuscarPacientes;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Paciente implements itrPaciente {
String Apellidos;
String Nombre;
String Direccion;
String Telefono;
Image Foto;

public Paciente(String Apellidos,String Nombre, String Direccion,String Telefono,Image Foto)
{
    this.Apellidos=Apellidos;
    this.Nombre=Nombre;
    this.Direccion=Direccion;
    this.Telefono=Direccion;
    this.Foto=Foto;
}

public void AgregarPaciente(Paciente NuevoPaciente)
{
    
}

public void BuscarPaciente(DefaultTableModel modelo, String Apellidos) {
        Conexion nuevaConexion = new Conexion();
        Connection conex;
        ResultSet Consulta = null;
        try {
            nuevaConexion.Conectar();
            conex = nuevaConexion.getConexion();
            Statement comando = conex.createStatement();
           
            Consulta = comando.executeQuery("select pacientes.idPaciente, pacientes.Nombre, pacientes.Apellidos, pacientes.DIreccion, pacientes.Telefono from pacientes where pacientes.Apellidos='"+Apellidos+"'");
                String pacientes[] = new String[5];
            while(Consulta.next()==true){
                pacientes[0]=Consulta.getString("idPaciente");
                pacientes[1]=Consulta.getString("Nombre");
                pacientes[2]=Consulta.getString("Apellidos");
                pacientes[3]=Consulta.getString("DIreccion");
                pacientes[4]=Consulta.getString("Telefono");
                modelo.addRow(pacientes);
            }
            
            {
                JDBuscarPacientes.jtPacientes.setModel(modelo);
            }
           
      } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error"+ e);
      } 
}

public void EditarPaciente(String Apellido)
{
    
}
public void EliminarPaciente(String Apellidos)
{
    
}
 public void Limpiar(DefaultTableModel modelo)
     {
      int filas = modelo.getRowCount();  
      
      for (int i=0;i<filas;i++)
      {
          modelo.removeRow(0);
      }
     }
}