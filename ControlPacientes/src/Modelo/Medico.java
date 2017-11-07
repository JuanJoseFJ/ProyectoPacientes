package Modelo;

import Modelo.Conexion;
import Modelo.IrtDoctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.omg.CosNaming.BindingType;

public class Medico implements IrtDoctor{
    //variables 
  String Apellidos;
  String Nombre;
  String Direccion;
  String Telefono;
  String colegiado;
  
  public Medico ()
  {
      
  }
  
  public Medico( String Apellidos,String Nombre,String Direccion,String Telefono, String colegiado)
  {
      
      this.Apellidos=Apellidos;
      this.Nombre=Nombre;
      this.Direccion=Direccion;
      this.Telefono=Telefono;
      this.colegiado = colegiado;
  }
  
    public void AutenticarMedico(String colegiado)
         {
         Conexion nuevoConexion = new Conexion();
         Connection conex;
         ResultSet consulta = null;
         try {
            nuevoConexion.Conectar(); // ejecuta el metodo conectar de la clase conexion el que contiene la direccion de la base de datos 
            conex = nuevoConexion.getConexion();  //aca se retorna la conexion que se obtuvo
            Statement comando = conex.createStatement(); 
            consulta = comando.executeQuery("select colegiado from doctores where colegiado = '"+colegiado+"' ");
            if(consulta.next()==true)
            {
                JOptionPane.showMessageDialog(null, "El numero de colegiado "+colegiado+" coincide con un Doctor ingresado anteriormente\n", "Error", JOptionPane.ERROR_MESSAGE);
            }
            conex.close();
            //return "Usuario agregado exitosamente";
        } catch (Exception e) {
            //return "Ha ocurrido un error al insertar datos: " +e; 
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al insertar datos: " +e);
        }
         }
    
    public  String AgregarMedico(Medico nMedico) {
        Conexion nconexion = new Conexion();  //objeto de la clase conexion
        Connection conex;
        ResultSet consulta = null;
        try
        {
            nconexion.Conectar(); // ejecuta el metodo conectar de la clase conexion el que contiene la direccion de la base de datos 
            conex = nconexion.getConexion();  //aca se retorna la conexion que se obtuvo
            Statement comando = conex.createStatement(); //comando para poder ejecutar executeUpdate
            consulta = comando.executeQuery("select colegiado from doctores where colegiado = '"+colegiado+"' ");
            if(consulta.next())
            {
                AutenticarMedico(colegiado);
            }
            else
            {
            comando.executeUpdate("insert into doctores() values('0','"+nMedico.Apellidos+"','"+nMedico.Nombre+"','"+nMedico.Direccion+"','"+nMedico.Telefono+"','"+nMedico.colegiado+"')");
            Icon i = new ImageIcon(getClass().getResource("/Imagenes/Aceptar.jpg"));
//            JOptionPane.showMessageDialog(null, "","Mensaje",JOptionPane.INFORMATION_MESSAGE, i);
            
            }
            conex.close();
            return "Medico agregado exitosamente";
        }
        
        catch(Exception e)
        {
            
            return "Ha ocurrido un error al agregar los datos del Medico "+e;
        }
    }

    
    public void BuscarMedico(String aux, DefaultTableModel tabla) {
        
        Conexion nconexion = new Conexion();  //objeto de la clase conexion
        Connection conex; 
         //vector horizontal que corresponde a cada columna de la tabla
        
        
        try
        {
            nconexion.Conectar(); // ejecuta el metodo conectar de la clase conexion el que contiene la direccion de la base de datos 
            conex = nconexion.getConexion();  //aca se retorna la conexion que se obtuvo
            Statement comando = conex.createStatement(); //comando para poder ejecutar executeUpdate
            String id="";
            String apellido="";
            String nombre="";
            String direccion="";
            String telefono="";
            String colegiado = "";
            String clave = aux;
            String datos2 []= new String[6];
         
            ResultSet consulta = comando.executeQuery("select doctores.idDoctor, doctores.Apellidos, doctores.Nombre, doctores.Direccion, doctores.Telefono, doctores.Colegiado from doctores where doctores.Apellidos='"+clave+"'");
        
              
            while(consulta.next()==true )
               
            {
//                id=consulta.getString("idDoctor");
//                apellido=consulta.getString("Apellidos");
//                nombre=consulta.getString("Nombre");
//                direccion=consulta.getString("Direccion");
//                telefono=consulta.getString("Telefono");
                datos2[0]=consulta.getString("idDoctor");
                datos2[1]=consulta.getString("Nombre");
                datos2[2]=consulta.getString("Apellidos");
                datos2[3]=consulta.getString("Direccion");
                datos2[4]=consulta.getString("Telefono");
                datos2[5]=consulta.getString("Colegiado");
                tabla.addRow(datos2);
                 
                        
            }
//            if(apellido.equals(clave))
//            {
//            String listar []={id, nombre, apellido, direccion, telefono};
//            tabla.addRow(listar);
//            
//            }
            conex.close(); //para cerrar en la base de datos 
       //conex.close() sirve para cerrar la conexion si se ejecuta la parte del codigo anterior 
           
        }
        
        catch(Exception e)
        {
            
            JOptionPane.showMessageDialog(null, "Medico no encontrado" +e); 
        }
        
    }

    public void PresentarDatos (DefaultTableModel tabla)
    {
        Conexion nconexion = new Conexion();  //objeto de la clase conexion
        Connection conex; 
         //vector horizontal que corresponde a cada columna de la tabla
        
        
        try
        {
            nconexion.Conectar(); // ejecuta el metodo conectar de la clase conexion el que contiene la direccion de la base de datos 
            conex = nconexion.getConexion();  //aca se retorna la conexion que se obtuvo
            Statement comando = conex.createStatement(); //comando para poder ejecutar executeUpdate
            String id="";
            String apellido="";
            String nombre="";
            String direccion="";
            String telefono="";
            String colegiado = "";
            String datos []= new String[6];
           
         
            ResultSet consulta = comando.executeQuery("select * from doctores");
        
              
            while(consulta.next()==true )
               
            {
                datos[0]=consulta.getString("idDoctor");
                datos[1]=consulta.getString("Nombre");
                datos[2]=consulta.getString("Apellidos");
                datos[3]=consulta.getString("Direccion");
                datos[4]=consulta.getString("Telefono");
                datos[5] = consulta.getString("Colegiado");
                tabla.addRow(datos);
                        
            }
            conex.close(); //para cerrar en la base de datos 
            
              
           
          
            //conex.close() sirve para cerrar la conexion si se ejecuta la parte del codigo anterior 
           
        }
        
        catch(Exception e)
        {
            
            JOptionPane.showMessageDialog(null, "Medico no encontrado" +e); 
        }
    }
    
    public String EditarMedico(Medico eMedico, String codigo) {
        Conexion nconexion = new Conexion();  //objeto de la clase conexion
        Connection conex; 
       
        
        try
        {
            nconexion.Conectar(); // ejecuta el metodo conectar de la clase conexion el que contiene la direccion de la base de datos 
            conex = nconexion.getConexion();  //aca se retorna la conexion que se obtuvo
            Statement comando = conex.createStatement(); //comando para poder ejecutar executeUpdate
            
            
//EJECUTAR LA CONSULTA DE INSERCION
                     
            
            
            
//            comando.executeUpdate("insert into doctores() values('0','"+eMedico.Apellidos+"','"+eMedico.Nombre+"','"+eMedico.Direccion+"','"+eMedico.Telefono+"')");
            PreparedStatement pps= conex.prepareStatement("UPDATE doctores SET doctores.Apellidos='"+eMedico.Apellidos+"', doctores.Nombre='"+eMedico.Nombre+"', doctores.Direccion='"+eMedico.Direccion+"', doctores.Telefono='"+eMedico.Telefono+"', doctores.Colegiado = '"+eMedico.colegiado+"' where doctores.idDoctor='"+codigo+"'");
            pps.executeUpdate();
           
            //executeUpdate sirve para actualizar la tabla en mysql
            //executeQuery sirve para consultar en la tabla de mysql   
           
            
            
            //conex.close() sirve para cerrar la conexion si se ejecuta la parte del codigo anterior 
            conex.close();
            Icon i = new ImageIcon(getClass().getResource("/Imagenes/Aceptar.jpg"));
//                JOptionPane.showMessageDialog(null, "","Mensaje",JOptionPane.INFORMATION_MESSAGE, i);
            return "Datos de Medico Editados Exitosamente";
         
            
        
        }
        
        
        catch(Exception e)
        {
            
            return "Ha ocurrido un error al editar los datos del medico: "+e;
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
    

   
    public String EliminarMedico(Medico elMedico,String codigo) {
        Conexion nconexion = new Conexion();  //objeto de la clase conexion
        Connection conex; 
       
        
        try
        {
            nconexion.Conectar(); // ejecuta el metodo conectar de la clase conexion el que contiene la direccion de la base de datos 
            conex = nconexion.getConexion();  //aca se retorna la conexion que se obtuvo
            Statement comando = conex.createStatement(); //comando para poder ejecutar executeUpdate
            
            
//EJECUTAR LA CONSULTA DE INSERCION
                     
            
            
            System.out.print(codigo);
//            comando.executeUpdate("insert into doctores() values('0','"+eMedico.Apellidos+"','"+eMedico.Nombre+"','"+eMedico.Direccion+"','"+eMedico.Telefono+"')");
            PreparedStatement pps= conex.prepareStatement("DELETE FROM doctores WHERE doctores.idDoctor='"+codigo+"'");
            pps.executeUpdate();
           
            //executeUpdate sirve para actualizar la tabla en mysql
            //executeQuery sirve para consultar en la tabla de mysql   
           
            
            
            //conex.close() sirve para cerrar la conexion si se ejecuta la parte del codigo anterior 
            conex.close();
            Icon i = new ImageIcon(getClass().getResource("/Imagenes/Aceptar.jpg"));
//                JOptionPane.showMessageDialog(null, "","Mensaje",JOptionPane.INFORMATION_MESSAGE, i);
            return "Medico Eliminado Exitosamente";
         
            
        
        }
        
        
        catch(Exception e)
        {
            
            return "Ha ocurrido un error al eliminar al Medico"+e;
        }
    
       
    }
          
}
