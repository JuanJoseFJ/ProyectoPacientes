package Modelo;


public interface itrPaciente {
    public void AgregarPaciente(Paciente nuevoPaciente);
    public void BuscarPaciente(String Apellidos);
    public void EditarPaciente(String Direccion,String tel);
    public void EliminarPaciente(String Apellidos);
}
