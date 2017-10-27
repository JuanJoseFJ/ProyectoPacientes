package Modelo;

import java.sql.Time;
import java.util.Date;


public interface itrCita {
    public void AgregarCita(String CodigoPaciente,String Fecha, int Hora,String CodigoDoctor);
    public void BuscarCita(String Apellidos);
    public void EditarCita(String Apellidos);
    public void EliminarCita(String Apellidos);
    
    
}
