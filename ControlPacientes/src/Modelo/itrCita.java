package Modelo;

import java.sql.Time;
import java.util.Date;
import javax.swing.table.DefaultTableModel;


public interface itrCita {
    public void AgregarCita(int CodigoPaciente,String Fecha, int Hora,int CodigoDoctor);
    public void BuscarCitaDoc(String ApelidosDoc, String fecha ,DefaultTableModel modelo);
    public void EditarCita(String Apellidos);
    public void EliminarCita(String apelPasiente, String apelDoctor, String fecha, int hora);
    
    
}
