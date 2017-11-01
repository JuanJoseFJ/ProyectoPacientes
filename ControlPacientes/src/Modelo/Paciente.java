package Modelo;

import java.awt.Image;

public class Paciente implements itrPaciente {
String Apellidos;
String Nombre;
String Direccion;
String Telefono;
Image Foto;

public Paciente(String Apellidos,String Nombre, String Direccion,String Telefono,Image Foto)
{
    this.Apellidos=Apellidos;
    this.Nombre=Nombre;
    this.Direccion=Direccion;
    this.Telefono=Direccion;
    this.Foto=Foto;
}
public void AgregarPaciente (Paciente NuevoPaciente)
{
    
}
public void BuscarPaciente (String Apellido)
{
    
}
public void EditarPaciente (String Apellido)
{
    
}
public void EliminarPaciente (String Apellido)
{
    
}
}
