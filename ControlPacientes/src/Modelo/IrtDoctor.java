package Modelo;

import javax.swing.table.DefaultTableModel;

public interface IrtDoctor {
    public String AgregarMedico(Medico nMedico);
    public void BuscarMedico(String Apellidos, DefaultTableModel tabla);
    public String EditarMedico(Medico eMedico, String codigo);
    public String EliminarMedico(Medico elMedico,String Codigo);
        
}
