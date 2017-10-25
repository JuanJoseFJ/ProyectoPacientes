package Modelo;

import java.sql.Time;
import java.util.Date;

public class Cita {
    String CodigoPaciente;
    Date Fecha;
    Time Hora;
    String CodigoDoctor;
    
    public Cita(String CodigoPaciente,Date Fecha, Time Hora,String CodigoDoctor)
    {
        this.CodigoPaciente=CodigoPaciente;
        this.Fecha=Fecha;
        this.Hora=Hora;
        this.CodigoDoctor=CodigoDoctor;
    }
}
