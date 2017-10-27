package Modelo;

import Vistas.JDAgregarCita;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cita  implements itrCita{   //esta clase IMPLEMENTA todo lo de la interfaz de cita

//OTRAS OPERACIONES
    
    //PARA LIMPIAR LA TABLA EN GENERAL
    public void limpiarTabla(DefaultTableModel modelo) //recibe el modelo de la tabla
    {
        int filas = modelo.getRowCount(); //para saber cuantas filas tiene la tabla hasta el momento
        for(int i=0;i<filas;i++)//colocamos "<" porque  sino borrara una fila inexistente
        {
            modelo.removeRow(0); //para que valla borrando borrando la PRIMERA linea(que en si es toda la tabla)
        }
    }    
    
    

//METODOS OBLICATORIOS

//PARA EL JDAgregar Visita
    public void AgregarCita(String CodigoPaciente,String Fecha, int Hora,String CodigoDoctor)  
    {
    //LO QUE SE QUIERE LOGRAR    
        //CONECTAR A LA BASE DE DATOS
        Conexion nuevaConexion = new Conexion();//creamos un objeto de la clase
        Connection conex ; //variable tipo coneccion 
        
        
        //INSERTAR EL REGISTRO QUE TENGA EN LA TABLA DE LA BASE DE DATOS
        try
        {
            nuevaConexion.Conectar(); //para que se ejecute el metodo de coneccion creado anteriormente
            
            conex = nuevaConexion.getConexion(); //le asignamos a conex la CONEXION creada con anterioridad en el metodo
            
            Statement comando = conex.createStatement();//preparamos un COMANDO para poder ejecutar
            
        //ejecutamos LA CONSULTA 
            comando.executeUpdate("insert into cita() values('"+0+"','"+CodigoPaciente+"','"+CodigoDoctor+"','"+Fecha+"','"+Hora+"')");
                                    //colocarle 0 para que actualice y coloque el dato de manera AUTOINCREMENTADA en la tabal
                                    
            conex.close();//para cerrar la base de datos
        
            //retorne que si se agrego
            JOptionPane.showMessageDialog(null, "Cita agregada exitosamente");  
                   
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error al agregar la cita: "+e);
                      
        }        
        
        
    }   
    
    
    //para que muestre los datos del paciente
    public String BuscarPaciente(String apellidos, DefaultTableModel modelo)
    {
    //LO QUE SE QUIERE LOGRAR    
        //CONECTAR A LA BASE DE DATOS
        Conexion nuevaConexion = new Conexion();//creamos un objeto de la clase
        Connection conex ; //variable tipo coneccion 
    //---------------------------------------------------------------------------------------------------------------    
        //objeto donde quedan los resultados
        ResultSet consulta = null; //se adaptara a la tabla de la base de datos para que obtenga los datos
    //---------------------------------------------------------------------------------------------------------------    
        
        //INSERTAR EL REGISTRO QUE TENGA EN LA TABLA DE LA BASE DE DATOS
        try
        {
            //realizamos una limpieza de la tabla antes de todo 
            limpiarTabla(modelo);
            
                        
            
            nuevaConexion.Conectar(); //para que se ejecute el metodo de coneccion creado anteriormente
            
            conex = nuevaConexion.getConexion(); //le asignamos a conex la CONEXION creada con anterioridad en el metodo
            
            Statement comando = conex.createStatement();//preparamos un COMANDO para poder ejecutar
            
            
            
            //JOptionPane.showMessageDialog(null, "Usuario: "+usuario+"   Contraseña: "+Pass);
        //ejecutamos LA CONSULTA 
            consulta = comando.executeQuery("select * from pacientes where Apellidos= '"+apellidos+"'"); //es "Query" porque solo CONSULTAMOS 
                          //NO cambiaremos nada                            |
                                                                    //"usuarios"  nombre de la FILA de la tabla en la base de datos 
                                                                                                        // "pass" es el nombre de la FILA de la tabal en la base de datos

                                                                                                        
        //Otra forma -------------------------------------------FORMA ORIGINAL-------------------------------------------------------------------------------------------------------
        //---------------si se hace de esta forma RECORDAR colocar la validacion cuando los campos ESTAN VACIOS en el formulario-----------------------------------------------------
            //Variables a utilizar
            int codPas= 0;
            String apelPas="";
            String nomPas="";
            String dirPas="";
            String telpas="";

            
            //para obtener los datos actuales
            while(consulta.next()==true)
            {
                //asignacion de los datos a las variables
                codPas = consulta.getInt("idPaciente");
                apelPas = consulta.getString("Apellidos");
                nomPas = consulta.getString("Nombre"); //en " " va el nombre de la columna en la base de datos
                dirPas = consulta.getString("DIreccion");
                telpas = consulta.getString("Telefono");

            }
            
            //comprobacion de los datos para saber si son iguales a los que estan en la Base de Datos
            if(apelPas.equals(apellidos)) //para saber si la columpa usuario es igual a "JFuentes"
                        //como son NUMEROS usamos el "=="
            {
                JOptionPane.showMessageDialog(null, "Los datos del paciente se mostraran en la tabla");
                

                //enviamos que se coloque el id del paciente en el txt
                JDAgregarCita.txtIdPaciente.setText(Integer.toString(codPas));  //pero debemos parcearlo

                //ceramos un vector donde se guardara cada dato por separado
                Vector x = new Vector();  //usamos la funcion "Vector" para crear un vector sin limites al cual se le asignara cada dato

                //ingresamos los datos al vector               
                x.addElement(apelPas);//agregamos el dato completo , de manera que cada dato tenga un lugar distinto en el vector   
                x.addElement(nomPas);
                x.addElement(dirPas);
                x.addElement(telpas);

                modelo.addRow(x);//enviamos la variable tipo "Vector" creado que contiene cada dato 
                    //y le decimos que crea una linea completa con los datos que contenca, pero como los datos ya estaran separados
                    //separara los datos mostrandolos en columnas distintas pero de la misma fila                                
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El paciente no esta registrado");
                
                
            }            
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------    
           
        
        
            
            conex.close();//para cerrar la base de datos
        
            //retorne que si se agrego
            return "consulta realizada exitosamente";   
        
        }
        catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null, "Usuario NO existente: "+e);
            
            //retorne que no se agrego
             return "A ocurrido un error al realizar la consulta"+e;              
        }
        
    }    
    
    
    //para que muestre los datos del doctor
    public String BuscarDoctor(String apellidos, DefaultTableModel modelo)
    {
    //LO QUE SE QUIERE LOGRAR    
        //CONECTAR A LA BASE DE DATOS
        Conexion nuevaConexion = new Conexion();//creamos un objeto de la clase
        Connection conex ; //variable tipo coneccion 
    //---------------------------------------------------------------------------------------------------------------    
        //objeto donde quedan los resultados
        ResultSet consulta = null; //se adaptara a la tabla de la base de datos para que obtenga los datos
    //---------------------------------------------------------------------------------------------------------------    
        
        //INSERTAR EL REGISTRO QUE TENGA EN LA TABLA DE LA BASE DE DATOS
        try
        {
            //realizamos una limpieza de la tabla antes de todo 
            limpiarTabla(modelo);
            
            
            nuevaConexion.Conectar(); //para que se ejecute el metodo de coneccion creado anteriormente
            
            conex = nuevaConexion.getConexion(); //le asignamos a conex la CONEXION creada con anterioridad en el metodo
            
            Statement comando = conex.createStatement();//preparamos un COMANDO para poder ejecutar
            
            
            
            //JOptionPane.showMessageDialog(null, "Usuario: "+usuario+"   Contraseña: "+Pass);
        //ejecutamos LA CONSULTA 
            consulta = comando.executeQuery("select * from doctores where Apellidos= '"+apellidos+"'"); //es "Query" porque solo CONSULTAMOS 
                          //NO cambiaremos nada                            |
                                                                    //"usuarios"  nombre de la FILA de la tabla en la base de datos 
                                                                                                        // "pass" es el nombre de la FILA de la tabal en la base de datos

                                                                                                        
        //Otra forma -------------------------------------------FORMA ORIGINAL-------------------------------------------------------------------------------------------------------
        //---------------si se hace de esta forma RECORDAR colocar la validacion cuando los campos ESTAN VACIOS en el formulario-----------------------------------------------------
            //Variables a utilizar
            int codDoc = 0;
            String apelDoc="";
            String nomDoc="";
            String dirDoc="";
            String telDoc="";

            
            //para obtener los datos actuales
            while(consulta.next()==true)
            {
                //asignacion de los datos a las variables
                codDoc = consulta.getInt("idDoctor");
                apelDoc = consulta.getString("Apellidos");
                nomDoc = consulta.getString("Nombre"); //en " " va el nombre de la columna en la base de datos
                dirDoc = consulta.getString("DIreccion");
                telDoc = consulta.getString("Telefono");

            }
            
            //comprobacion de los datos para saber si son iguales a los que estan en la Base de Datos
            if(apelDoc.equals(apellidos)) //para saber si la columpa usuario es igual a "JFuentes"
                        //como son NUMEROS usamos el "=="
            {
                JOptionPane.showMessageDialog(null, "Los datos del doctor se mostraran en la tabla");
                
                //enviamos el dato al txt del id del doctor
                JDAgregarCita.txtIdDoctor.setText(Integer.toString(codDoc));
                
                
                //ceramos un vector donde se guardara cada dato por separado 
                Vector x = new Vector();  //usamos la funcion "Vector" para crear un vector sin limites al cual se le asignara cada dato

                //ingresamos los datos al vector               
                x.addElement(apelDoc);//agregamos el dato completo , de manera que cada dato tenga un lugar distinto en el vector   
                x.addElement(nomDoc);
                x.addElement(dirDoc);
                x.addElement(telDoc);

                modelo.addRow(x);//enviamos la variable tipo "Vector" creado que contiene cada dato 
                    //y le decimos que crea una linea completa con los datos que contenca, pero como los datos ya estaran separados
                    //separara los datos mostrandolos en columnas distintas pero de la misma fila                                
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El doctor no esta registrado");
                
                
            }            
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------    
           
        
        
            
            conex.close();//para cerrar la base de datos
        
            //retorne que si se agrego
            return "consulta realizada exitosamente";   
        
        }
        catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null, "Usuario NO existente: "+e);
            
            //retorne que no se agrego
             return "A ocurrido un error al realizar la consulta"+e;              
        }
        
    }    
    
    
    //validacion de la hora de la cita antes de enviarla                                    ESTE METODO SE EJECUTA ANTES DEL DE AGREGARCITA
    public String ValidacionCita(String CodigoPaciente,String Fecha, int Hora,String CodigoDoctor, DefaultTableModel modeloPacientes, DefaultTableModel modeloDoctores)    
    {
    //LO QUE SE QUIERE LOGRAR    
        //CONECTAR A LA BASE DE DATOS
        Conexion nuevaConexion = new Conexion();//creamos un objeto de la clase
        Connection conex ; //variable tipo coneccion 
    //---------------------------------------------------------------------------------------------------------------    
        //objeto donde quedan los resultados
        ResultSet consulta = null; //se adaptara a la tabla de la base de datos para que obtenga los datos
    //---------------------------------------------------------------------------------------------------------------    
        
        //INSERTAR EL REGISTRO QUE TENGA EN LA TABLA DE LA BASE DE DATOS
        try
        {
            
                        
            
            nuevaConexion.Conectar(); //para que se ejecute el metodo de coneccion creado anteriormente
            
            conex = nuevaConexion.getConexion(); //le asignamos a conex la CONEXION creada con anterioridad en el metodo
            
            Statement comando = conex.createStatement();//preparamos un COMANDO para poder ejecutar
            
            
            
            //JOptionPane.showMessageDialog(null, "Usuario: "+usuario+"   Contraseña: "+Pass);
        //ejecutamos LA CONSULTA 
            consulta = comando.executeQuery("select * from cita where Hora='"+Hora+"' and Fecha='"+Fecha+"'"); //es "Query" porque solo CONSULTAMOS 
                          //NO cambiaremos nada                            |
                                                                    //"usuarios"  nombre de la FILA de la tabla en la base de datos 
                                                                                                        // "pass" es el nombre de la FILA de la tabal en la base de datos

                                                                                                        
        //Otra forma -------------------------------------------FORMA ORIGINAL-------------------------------------------------------------------------------------------------------
        //---------------si se hace de esta forma RECORDAR colocar la validacion cuando los campos ESTAN VACIOS en el formulario-----------------------------------------------------
            //Variables a utilizar
            int horaCita= 0;
            String fechaCita="";
            
            //para obtener los datos actuales
            while(consulta.next()==true)
            {
                //asignacion de los datos a las variables
                horaCita = consulta.getInt("Hora");
                fechaCita = consulta.getString("Fecha");

            }
            
            //comprobacion de los datos para saber si son iguales a los que estan en la Base de Datos
            if(horaCita == Hora && fechaCita.equals(Fecha)) //para saber si la columpa usuario es igual a "JFuentes"
                        //como son NUMEROS usamos el "=="
            { //si existe una hora igual 
                JOptionPane.showMessageDialog(null, "EROR: existe una cita a esa hora en el mismo dia, por favor ingrese una hora o dia distinto");                              
                
            }
            else //si no existe una hora igual, entonces enviamos directamente los datos a que se guarden 
            {
               
                AgregarCita(CodigoPaciente, Fecha, Hora, CodigoDoctor);
                
                //limpiamos los txt
                JDAgregarCita.txtApelDoctor.setText("");
                JDAgregarCita.txtIdDoctor.setText("");
                JDAgregarCita.txtApelPaciente.setText("");
                JDAgregarCita.txtIdPaciente.setText("");
                JDAgregarCita.txtHora.setText("");
                JDAgregarCita.JDTfecha.setCalendar(null);   //OJOOOOOOO es distinto limpiar un jDate chooset
                
                //limpiamos las tablas 
                limpiarTabla(modeloDoctores);
                limpiarTabla(modeloPacientes);                 
                
            }            
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------    
           
        
        
            
            conex.close();//para cerrar la base de datos
        
            //retorne que si se agrego
            return "consulta realizada exitosamente";   
        
        }
        catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null, "Usuario NO existente: "+e);
            
            //retorne que no se agrego
             return "A ocurrido un error al realizar la consulta"+e;              
        }
        
    }    
    
    
    
    
    public void BuscarCita(String Apellidos)
    {
        
    }
    
    
    
    public void EditarCita(String Apellidos)
    {
        
    }
    
    
    
    
    public void EliminarCita(String Apellidos)
    {
        
        
    }  
    
    
}
