package Modelo;

import Vistas.JDAgregarCita;
import Vistas.JDEditarCita;
import Vistas.JDIngresarPaciente;
import Vistas.JFprincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
    
//AGREGAR    
    //PARA AGREGAR LA CITA LUEGO DE LAS VALIDACIONES CORRESPONDIENTES
        public void AgregarCita(int CodigoPaciente,String Fecha, int Hora, int CodigoDoctor)  
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
            JDAgregarCita.txtIdPaciente.setText("");  //tambien limpiamos la casilla oculta del idPaciente
                        
            
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
                 
                int accion = JOptionPane.showConfirmDialog(null, "El paciente no esta registrado, desea agregar uno?");
                if(accion == JOptionPane.YES_OPTION)
                {
                    JDIngresarPaciente frmPaciente = new JDIngresarPaciente(new JFprincipal(), true);
                    frmPaciente.setLocationRelativeTo(null);
                    frmPaciente.setVisible(true);
                }
                
                
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
    
    //para buscar el id del doctor                                                         ESTE METODO SE EJECUTA ANTES DE VALIDAR LOS DATOS
    public String BuscarIdDoctor(int CodigoPaciente,String Fecha, int Hora, String ApellidosDoctor, DefaultTableModel modeloPacientes)
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
            consulta = comando.executeQuery("select * from doctores where Apellidos= '"+ApellidosDoctor+"'"); //es "Query" porque solo CONSULTAMOS 
                          //NO cambiaremos nada                            |
                                                                    //"usuarios"  nombre de la FILA de la tabla en la base de datos 
                                                                                                        // "pass" es el nombre de la FILA de la tabal en la base de datos

                                                                                                        
        //Otra forma -------------------------------------------FORMA ORIGINAL-------------------------------------------------------------------------------------------------------
        //---------------si se hace de esta forma RECORDAR colocar la validacion cuando los campos ESTAN VACIOS en el formulario-----------------------------------------------------
            //Variables a utilizar
            int codDoc= 0;
            String apelDoc="";

            
            //para obtener los datos actuales
            while(consulta.next()==true)
            {
                //asignacion de los datos a las variables
                codDoc = consulta.getInt("idDoctor");
                apelDoc = consulta.getString("Apellidos");

            }
            
            if(apelDoc.equals(ApellidosDoctor))
            {
                //llamamos al metrodo de verificacion de datos
                ValidacionCita(CodigoPaciente, Fecha, Hora, codDoc, modeloPacientes);                
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
    public String ValidacionCita(int CodigoPaciente,String Fecha, int Hora, int CodigoDoctor, DefaultTableModel modeloPacientes)    
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
            
            consulta = comando.executeQuery("select * from cita where idDoctor= '"+CodigoDoctor+"' and Fecha= '"+Fecha+"' and Hora= '"+Hora+"'"); //es "Query" porque solo CONSULTAMOS
                          //NO cambiaremos nada                            |
                                                                    //"usuarios"  nombre de la FILA de la tabla en la base de datos 
                                                                                                        // "pass" es el nombre de la FILA de la tabal en la base de datos

                                                                                                        
        //Otra forma -------------------------------------------FORMA ORIGINAL-------------------------------------------------------------------------------------------------------
        //---------------si se hace de esta forma RECORDAR colocar la validacion cuando los campos ESTAN VACIOS en el formulario-----------------------------------------------------
            //Variables a utilizar
            int horaCita= 0;
            int codigoDoc= 0;
            String fechaCita="";
            
            //para obtener los datos actuales
            while(consulta.next()==true)
            {
                //asignacion de los datos a las variables
                codigoDoc = consulta.getInt("idDoctor");
                horaCita = consulta.getInt("Hora");
                fechaCita = consulta.getString("Fecha");

            }
            
            //comprobacion de los datos para saber si son iguales a los que estan en la Base de Datos
            if(codigoDoc==CodigoDoctor && horaCita == Hora && fechaCita.equals(Fecha)) //para saber si la columpa usuario es igual a "JFuentes"
                        //como son NUMEROS usamos el "=="
            { //si existe una hora igual 
                JOptionPane.showMessageDialog(null, "EROR: el doctor tine una cita a esa hora en el mismo dia, por favor ingrese una hora o dia distinto");                              
                
            }
            else //si no existe una hora igual, entonces enviamos directamente los datos a que se guarden 
            {
               
                AgregarCita(CodigoPaciente, Fecha, Hora, CodigoDoctor);
                
                //limpiamos los txt
                JDAgregarCita.txtApelPaciente.setText("");
                JDAgregarCita.txtIdPaciente.setText("");
                JDAgregarCita.txtHora.setText("");
                JDAgregarCita.JDTfecha.setCalendar(null);   //OJOOOOOOO es distinto limpiar un jDate chooset
                
                //limpiamos las tablas 
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
    
    
    
//BUSCAR
    //Para buscar una cita pero por doctor 
    public void BuscarCitaDoc(String ApelidosDoc, String fecha ,DefaultTableModel modelo)  //le colocamos string para en algun momento usar un JOption para saber si hay un error y cual es
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
            //limpiamos la tabla antes de meter datos
            limpiarTabla(modelo);
            
            
            
            nuevaConexion.Conectar(); //para que se ejecute el metodo de coneccion creado anteriormente
            
            conex = nuevaConexion.getConexion(); //le asignamos a conex la CONEXION creada con anterioridad en el metodo
            
            Statement comando = conex.createStatement();//preparamos un COMANDO para poder ejecutar
            
            
            
            //JOptionPane.showMessageDialog(null, "Usuario: "+usuario+"   Contraseña: "+Pass);
        //ejecutamos LA CONSULTA 
            consulta = comando.executeQuery("select pacientes.idPaciente, pacientes.Nombre, pacientes.Apellidos, doctores.idDoctor, doctores.Apellidos, cita.idPaciente, cita.idDoctor, cita.Fecha, cita.Hora from pacientes, doctores , cita where doctores.idDoctor=cita.idDoctor and pacientes.idPaciente=cita.idPaciente and doctores.Apellidos='"+ApelidosDoc+"' and cita.Fecha='"+fecha+"' "); //es "Query" porque solo CONSULTAMOS 
                          //NO cambiaremos nada                                                                                                                                                         usamos el "where" para indicar que datos vamos a obtener de cada tabla cuando se cumplan todas las condiciones 
                          //vamos a tomar solo algunos datos de las tablas, por eso usamos el "." para indicar que parte de la tabla obtendremos

                                                                                                        
        //Otra forma -------------------------------------------FORMA ORIGINAL-------------------------------------------------------------------------------------------------------
        //---------------si se hace de esta forma RECORDAR colocar la validacion cuando los campos ESTAN VACIOS en el formulario-----------------------------------------------------
            //Variables a utilizar
            String nomPas="";
            String apelPas="";
            int horaVis=0;

            //Contador para la columna "No."
            int contador=1;
            
            //para obtener los datos actuales
            while(consulta.next()==true) //mientras hallan datos
            {

                //asignacion de los datos a las variables    usamos "." para indicar de donde viene 
                nomPas = consulta.getString("pacientes.Nombre");//en " " va el nombre del la columna 
                apelPas = consulta.getString("pacientes.Apellidos");//en " " va el nombre del la columna 
                horaVis = consulta.getInt("cita.Hora");//en " " va el nombre del la columna 
                
                //ceramos un vector donde se guardara cada dato por separado 
                Vector x = new Vector();  //usamos la funcion "Vector" para crear un vector sin limites al cual se le asignara cada dato
                
                
                //ingresamos los datos al vector  
                x.addElement(contador); //enviamos el contador
                x.addElement(apelPas);//agregamos el dato completo , de manera que cada dato tenga un lugar distinto en el vector   
                x.addElement(nomPas);
                x.addElement(horaVis);

                modelo.addRow(x);//enviamos la variable tipo "Vector" creado que contiene cada dato 
                    //y le decimos que crea una linea completa con los datos que contenca, pero como los datos ya estaran separados
                    //separara los datos mostrandolos en columnas distintas pero de la misma fila 

                //le sumamos 1 al contador
                contador=contador+1;
            }
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------    
                  
        
        
            conex.close();//para cerrar la base de datos
        
            //retorne que si se agrego
            JOptionPane.showMessageDialog(null, "Las citas se mostraran en la tabla ");   
            
        
        }
        catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null, "Usuario NO existente: "+e);
            
            //retorne que no se agrego
             JOptionPane.showMessageDialog(null, "Error al mostrar las citas: "+e);               
        }
        
    }
    
    
    //Para buscar una cita pero por el paciente
    public void BuscarCitaPas(String ApelidosPaciente, DefaultTableModel modelo)  //le colocamos string para en algun momento usar un JOption para saber si hay un error y cual es
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
            //limpiamos la tabla antes de meter datos
            limpiarTabla(modelo);
            
            
            
            nuevaConexion.Conectar(); //para que se ejecute el metodo de coneccion creado anteriormente
            
            conex = nuevaConexion.getConexion(); //le asignamos a conex la CONEXION creada con anterioridad en el metodo
            
            Statement comando = conex.createStatement();//preparamos un COMANDO para poder ejecutar
            
            
            
            //JOptionPane.showMessageDialog(null, "Usuario: "+usuario+"   Contraseña: "+Pass);
        //ejecutamos LA CONSULTA 
            consulta = comando.executeQuery("select pacientes.idPaciente, pacientes.Apellidos, doctores.idDoctor, doctores.Apellidos, doctores.Nombre, cita.idPaciente, cita.idDoctor, cita.Fecha, cita.Hora from pacientes, doctores , cita where doctores.idDoctor=cita.idDoctor and pacientes.idPaciente=cita.idPaciente and pacientes.Apellidos='"+ApelidosPaciente+"' "); //es "Query" porque solo CONSULTAMOS 
                          //NO cambiaremos nada                                                                                                                                                         usamos el "where" para indicar que datos vamos a obtener de cada tabla cuando se cumplan todas las condiciones 
                          //vamos a tomar solo algunos datos de las tablas, por eso usamos el "." para indicar que parte de la tabla obtendremos

                                                                                                        
        //Otra forma -------------------------------------------FORMA ORIGINAL-------------------------------------------------------------------------------------------------------
        //---------------si se hace de esta forma RECORDAR colocar la validacion cuando los campos ESTAN VACIOS en el formulario-----------------------------------------------------
            //Variables a utilizar
            String nomDoc="";
            String apelDoc="";
            String fechaVis="";
            int horaVis=0;

            
            //para obtener los datos actuales
            while(consulta.next()==true) //mientras hallan datos
            {

                //asignacion de los datos a las variables    usamos "." para indicar de donde viene 
                nomDoc = consulta.getString("doctores.Nombre");//en " " va el nombre del la columna 
                apelDoc = consulta.getString("doctores.Apellidos");//en " " va el nombre del la columna 
                fechaVis = consulta.getString("cita.Fecha");
                horaVis = consulta.getInt("cita.Hora");//en " " va el nombre del la columna 
                
                //ceramos un vector donde se guardara cada dato por separado 
                Vector x = new Vector();  //usamos la funcion "Vector" para crear un vector sin limites al cual se le asignara cada dato
                
                
                //ingresamos los datos al vector  
                x.addElement(apelDoc);//agregamos el dato completo , de manera que cada dato tenga un lugar distinto en el vector   
                x.addElement(nomDoc);
                x.addElement(fechaVis);
                x.addElement(horaVis);

                modelo.addRow(x);//enviamos la variable tipo "Vector" creado que contiene cada dato 
                    //y le decimos que crea una linea completa con los datos que contenca, pero como los datos ya estaran separados
                    //separara los datos mostrandolos en columnas distintas pero de la misma fila 

            }
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------    
                  
        
        
            conex.close();//para cerrar la base de datos
        
            //retorne que si se agrego
            JOptionPane.showMessageDialog(null, "Las informacion se mostraran en la tabla ");   
            
        
        }
        catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null, "Usuario NO existente: "+e);
            
            //retorne que no se agrego
             JOptionPane.showMessageDialog(null, "Error al mostrar la informacion: "+e);               
        }
        
    }
    
    
    //para listar los doctores actuales  GENERAL 
    public String ColocarDoctoresCBX(JComboBox ListaDoctores)
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
            consulta = comando.executeQuery("select * from doctores "); //es "Query" porque solo CONSULTAMOS 
                          //NO cambiaremos nada                            
                                            //usamos el "select *" para que seleccione todo 
                                                                                                        
        //Otra forma -------------------------------------------FORMA ORIGINAL-------------------------------------------------------------------------------------------------------
        //---------------si se hace de esta forma RECORDAR colocar la validacion cuando los campos ESTAN VACIOS en el formulario-----------------------------------------------------
            //Variables a utilizar
            String apelDoc="";
            
            //para obtener los datos actuales
            while(consulta.next()==true)
            {
                //asignacion de los datos a las variables
                apelDoc = consulta.getString("Apellidos"); //en " " va el nombre de la columna en la base de datos                
                
                //para colocarlo en el combobox
                ListaDoctores.addItem(apelDoc);//le asignamos el nombre de la unidad al bombobox del JDvisitas             
                
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
    
    
    
//EDITAR    
    //Para editar la base de datos
    public void EditarCita(String Apellidos)
    {
        
    }
    
        
    //para buscar los ids                                                        ESTE METODO SE EJECUTA ANTES DE VALIDAR LOS DATOS
    public String BuscarIdsEditar(String ApellidosPaciente, String Fecha, int Hora, String ApellidosDoctor, DefaultTableModel modelo, JTable datostabla, String fechaAnterior, String doctorAnterior)
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
            consulta = comando.executeQuery("select doctores.idDoctor, doctores.Apellidos, pacientes.idPaciente, pacientes.Apellidos from doctores, pacientes where doctores.Apellidos= '"+ApellidosDoctor+"' and pacientes.Apellidos= '"+ApellidosPaciente+"'"); //es "Query" porque solo CONSULTAMOS 
                          //NO cambiaremos nada                            |
                                                                    //"usuarios"  nombre de la FILA de la tabla en la base de datos 
                                                                                                        // "pass" es el nombre de la FILA de la tabal en la base de datos

                                                                                                        
        //Otra forma -------------------------------------------FORMA ORIGINAL-------------------------------------------------------------------------------------------------------
        //---------------si se hace de esta forma RECORDAR colocar la validacion cuando los campos ESTAN VACIOS en el formulario-----------------------------------------------------
            //Variables a utilizar
            int idPas= 0;
            int idDoc= 0;
            String apelDoc="";
            String apelPas="";
            
            //para obtener los datos actuales
            while(consulta.next()==true)
            {
                //asignacion de los datos a las variables
                idPas = consulta.getInt("pacientes.idPaciente");
                idDoc = consulta.getInt("doctores.idDoctor");
                apelDoc = consulta.getString("doctores.Apellidos");
                apelPas = consulta.getString("pacientes.Apellidos");

            }
            
            if(apelDoc.equals(ApellidosDoctor) && apelPas.equals(ApellidosPaciente))
            {
                
                //llamamos al metrodo de verificacion de datos
                ValidacionCitaEditar(idPas, Fecha, Hora, idDoc, modelo, datostabla, fechaAnterior, doctorAnterior);
                
                
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
    public String ValidacionCitaEditar(int CodigoPaciente,String Fecha, int Hora, int CodigoDoctor, DefaultTableModel modelocitasEditar, JTable datostabla, String fechaAnterior, String doctorAnterior)    
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
            
            consulta = comando.executeQuery("select * from cita where idDoctor= '"+CodigoDoctor+"' and Fecha= '"+Fecha+"' and Hora= '"+Hora+"'"); //es "Query" porque solo CONSULTAMOS
                          //NO cambiaremos nada                            |
                                                                    //"usuarios"  nombre de la FILA de la tabla en la base de datos 
                                                                                                        // "pass" es el nombre de la FILA de la tabal en la base de datos

                                                                                                        
        //Otra forma -------------------------------------------FORMA ORIGINAL-------------------------------------------------------------------------------------------------------
        //---------------si se hace de esta forma RECORDAR colocar la validacion cuando los campos ESTAN VACIOS en el formulario-----------------------------------------------------
            //Variables a utilizar
            int horaCita= 0;
            int codigoDoc= 0;
            String fechaCita="";
            
            //para obtener los datos actuales
            while(consulta.next()==true)
            {
                //asignacion de los datos a las variables
                codigoDoc = consulta.getInt("idDoctor");
                horaCita = consulta.getInt("Hora");
                fechaCita = consulta.getString("Fecha");

            }
            
            //comprobacion de los datos para saber si son iguales a los que estan en la Base de Datos
            if(codigoDoc==CodigoDoctor && horaCita == Hora && fechaCita.equals(Fecha)) //para saber si la columpa usuario es igual a "JFuentes"
                        //como son NUMEROS usamos el "=="
            { //si existe una hora igual 
                JOptionPane.showMessageDialog(null, "ERROR: el doctor tine una cita a esa hora en el mismo dia, por favor ingrese una hora o dia distinto");                              
                
            }
            else //si no existe una hora igual, entonces enviamos directamente los datos a que se guarden 
            {
               //se agrega el nuevo registro con los datos nuevos
                AgregarCita(CodigoPaciente, Fecha, Hora, CodigoDoctor);
                
                //tambien llamamos al metodo para que elimine el registro que se esta editando
                datosFilaSeleccionada(datostabla, modelocitasEditar, fechaAnterior, doctorAnterior);
                
                //limpiamos los txt
                JDEditarCita.JDFechaCitaEditar.setCalendar(null);
                JDEditarCita.txtApellidosPacienteEdit.setText("");
                JDEditarCita.txtHoraEditar.setText("");
                JDEditarCita.jdFechaEditar.setCalendar(null);   //OJOOOOOOO es distinto limpiar un jDate chooset
                
                //limpiamos las tablas 
                limpiarTabla(modelocitasEditar);                                 
                
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
    
      
        
    
//ELIMINAR
    //Para imprimir el codigo de la fila seleccionada
    public void datosFilaSeleccionada(JTable datostabla,DefaultTableModel modelo, String fecha, String apelDoctor)
                        //el "JTable" es para recibir la tabla ya con los datos
    {
        //Usando la variable que contiene LA TABLA CON LOS DATOS INTRODUCIDOS "datostabla"
        int seleccion = datostabla.getSelectedRow(); //para saber si hay o no una seleccion en la tabla


        String apelPaciente; //para guardar el codigo de la seleccion
        int horaCita;//para guardar el nombre del curso de la seleccion

        if(seleccion == -1)//si no se a seleccionado ninguna fila
                    //la variable "seleccion" varia en base a la fila seleccionada
                    //tomando cada fila con valores como un vector, iniciando desde "0"
        {
            JOptionPane.showMessageDialog(null, "ERROR: no se ha seleccionado ninguna fila para eliminar");
        }
        else
        {
            apelPaciente = (String) datostabla.getValueAt(seleccion, 1); //guardamos el apellido de la fila seleccionada
                            //en una variable string 

            horaCita = (int) datostabla.getValueAt(seleccion, 3); //guardamos la hora de la fila seleccionada
                            //en una variable string                             
                            
            //Usando la VARIABLE TIPO TABLA "modelo"
            modelo.removeRow(seleccion); //utilizamos el modelo de la tabla para eliminar la fila  SOLO VISUALMENTE

            //------------------PARA REALIZAR LA ELIMINACION EN EL ARCHIVO-----------------------------------------------------------------------------------


            EliminarCita(apelPaciente, apelDoctor, fecha, horaCita); //enviamos el modelo que recibimos y el codigo que ya sustraimos de la selecion




            //------------------------------------------------------------------------------------------------------------------------------------------------

        }
    }

    //Para eliminar la cita de la base de datos
    public void EliminarCita(String apelPasiente, String apelDoctor, String fecha, int hora)
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
            consulta = comando.executeQuery("select pacientes.idPaciente, pacientes.Apellidos, doctores.idDoctor, doctores.Apellidos, cita.idPaciente, cita.idDoctor, cita.Fecha, cita.Hora from pacientes, doctores , cita where doctores.idDoctor=cita.idDoctor and pacientes.idPaciente=cita.idPaciente and pacientes.Apellidos='"+apelPasiente+"' and doctores.Apellidos='"+apelDoctor+"' and cita.Fecha='"+fecha+"' and cita.Hora='"+hora+"' "); //es "Query" porque solo CONSULTAMOS 
                          //NO cambiaremos nada                                                                                                                                                         usamos el "where" para indicar que datos vamos a obtener de cada tabla cuando se cumplan todas las condiciones 
                          //vamos a tomar solo algunos datos de las tablas, por eso usamos el "." para indicar que parte de la tabla obtendremos

                                                                                                        
        //Otra forma -------------------------------------------FORMA ORIGINAL-------------------------------------------------------------------------------------------------------
        //---------------si se hace de esta forma RECORDAR colocar la validacion cuando los campos ESTAN VACIOS en el formulario-----------------------------------------------------
            //Variables a utilizar
            String apelPas="";
            String apelDoc="";
            int idDoc=0;
            int idPas=0;
            String fechaVis="";
            int horaVis=0;

            
            //para obtener los datos actuales
            while(consulta.next()==true) //mientras hallan datos
            {
                //asignacion de los datos a las variables    usamos "." para indicar de donde viene 
                apelPas = consulta.getString("pacientes.Apellidos");//en " " va el nombre del la columna 
                apelDoc = consulta.getString("doctores.Apellidos");//en " " va el nombre del la columna 
                idDoc = consulta.getInt("doctores.idDoctor");
                idPas = consulta.getInt("pacientes.idPaciente");
                fechaVis = consulta.getString("cita.Fecha");
                horaVis = consulta.getInt("cita.Hora");//en " " va el nombre del la columna 
            }
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------    
             if(apelPas.equals(apelPasiente) && apelDoc.equals(apelDoctor) && fechaVis.equals(fecha) && horaVis==hora)
             { 
                // PARAAAAAAAAAAAAAAAAAA ELIMINAR UN DATO EN LA BASE DE DATOS -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
                 
                 
                 comando.executeUpdate("DELETE FROM cita where idPaciente='"+idPas+"' and idDoctor='"+idDoc+"' and Fecha='"+fechaVis+"' and Hora='"+horaVis+"' ");
                 
               // -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*  
                 
                //retorne que si se agrego
                JOptionPane.showMessageDialog(null, "Las cita ha sido eliminada correctamente");               
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "EROR: no se encontraron las semejansas en los datos ");
             }
        
        
            conex.close();//para cerrar la base de datos
        
            
        
        }
        catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null, "Usuario NO existente: "+e);
            
            //retorne que no se agrego
             JOptionPane.showMessageDialog(null, "Error al eliminar la cita: "+e);               
        }        
        
    }  
    
    
}
