package Modelo;


public interface itrPaciente {
    public void AgregarPaciente(Paciente nuevoPaciente);
    public void BuscarPaciente(String Apellidos);
    public void EditarPaciente(String Apellidos);
    public void EliminarPaciente(String Apellidos);
}
