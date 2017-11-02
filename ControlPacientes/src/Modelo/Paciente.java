package Modelo;

import Vistas.JDeditarpaciente;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

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

 
    public void AgregarPaciente(Paciente nuevoPaciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public void BuscarPaciente(String Apellidos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public void EditarPaciente(String Direccion, String tel) {
        
        Conexion nuevaConexion = new Conexion();
        Connection conex;
      
        try {
            nuevaConexion.Conectar();
              conex = nuevaConexion.getConexion();
              Statement comando = conex.createStatement();
            comando.executeUpdate("UPDATE  pacientes SET DIreccion='"+Direccion+"',Telefono='"+tel+"' where pacientes.idPaciente='"+JDeditarpaciente.txtid.getText()+"'");
            JOptionPane.showMessageDialog(null, "modificado exitosamente");
            conex.close();
                    } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error no se puede modificar"+e);
        }
       
    }

   
    public void EliminarPaciente(String Apellidos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
