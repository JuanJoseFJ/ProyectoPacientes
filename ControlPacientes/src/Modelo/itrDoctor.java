package Modelo;

public interface itrDoctor {
    public void AgregarMedico(Medico nuevoMedico);
    public void BuscarMedico(String Apellidos);
    public void EditarMedico(String Apellidos,String Direccion,String tel);
    public void EliminarMedico(String Apellidos);
        
}
