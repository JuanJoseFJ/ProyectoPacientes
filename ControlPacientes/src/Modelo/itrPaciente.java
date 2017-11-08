package Modelo;

import javax.swing.table.DefaultTableModel;


public interface itrPaciente {
    public void AgregarPaciente(Paciente nuevoPaciente);
    public void BuscarPaciente(DefaultTableModel modelo, String Apellidos);
    public void EditarPaciente(String Direccion,String tel);
    public void EliminarPaciente(String Apellidos);
}
