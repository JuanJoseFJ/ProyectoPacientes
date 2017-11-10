package Modelo;

import Vistas.JDBuscarPacientes;
import Vistas.JDeditarpaciente;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Paciente implements itrPaciente {
String Apellidos;
String Nombre;
String Direccion;
String Telefono;
String Foto;
String Observaciones;

public Paciente(String Apellidos,String Nombre, String Direccion,String Telefono,String Foto,String Observaciones)
{
    this.Apellidos=Apellidos;
    this.Nombre=Nombre;
    this.Direccion=Direccion;
    this.Telefono=Telefono;
    this.Foto=Foto;
    this.Observaciones = Observaciones;
}
  

public void AgregarPaciente(Paciente NuevoPaciente)
{
    Conexion Conectar = new Conexion();
    Connection conex;
    try {
        FileInputStream archivoF;
        archivoF = new FileInputStream(NuevoPaciente.Foto);
        Conectar.Conectar();
        conex = Conectar.getConexion();
        Statement comando = conex.createStatement();
        comando.executeUpdate("insert into Pacientes() values('0','"+NuevoPaciente.Nombre+"','"+NuevoPaciente.Apellidos+"','"+NuevoPaciente.Direccion+"','"+NuevoPaciente.Telefono+"','"+archivoF+"','"+NuevoPaciente.Observaciones+"')");
        JOptionPane.showMessageDialog(null, "Paciente agregado Correctamente");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Ocurrior un error "+e);
    }
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


public void EliminarPaciente(int id)
{
    Conexion nuevaConexion = new Conexion();
        Connection conex;
        
        try{
            nuevaConexion.Conectar();
            conex= nuevaConexion.getConexion();
            Statement comando = conex.createStatement();
            PreparedStatement pps= conex.prepareStatement("DELETE FROM pacientes WHERE idPaciente='"+id+"'");
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Paciente eliminado con exito");
            
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error"+ e);
        }
}

public void EliminarDiagnostico(int id)
    {
        Conexion nuevaConexion = new Conexion();
        Connection conex;
        try
        {
            nuevaConexion.Conectar();
            conex= nuevaConexion.getConexion();
            Statement comando = conex.createStatement();
            PreparedStatement pps= conex.prepareStatement("DELETE FROM diagnostico WHERE idPaciente='"+id+"'");
            pps.executeUpdate();
            
        }
        catch(Exception e)
        {
                    JOptionPane.showMessageDialog(null,"Error"+e);
        }
    }


public void Limpiar(DefaultTableModel modelo)
     {
      int filas = modelo.getRowCount();  
      
      for (int i=0;i<filas;i++)
      {
          modelo.removeRow(0);
      }
     }

   
@Override
    public void EditarPaciente(String Direccion, String tel){
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
public void AgregarConsulta(int CodPaciente,String Sintomas, String PresionA, String OtrosD)
    {
     Conexion Conectar = new Conexion();
     Connection conex;   
        try {
        Conectar.Conectar();
        conex = Conectar.getConexion();
        Statement comando = conex.createStatement();
        comando.executeUpdate("insert into Diagnostico() values('0','"+CodPaciente+"','"+Sintomas+"','"+PresionA+"','"+OtrosD+"')");
        JOptionPane.showMessageDialog(null, "Diagnostico agregado Correctamente");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Ocurrior un error "+e);
        }
    }
    
}