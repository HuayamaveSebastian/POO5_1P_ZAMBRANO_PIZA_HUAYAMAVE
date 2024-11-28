package com.example;
import com.example.Enums.*;
public abstract class Usuario {
    protected String nombre;
    protected String apellido;
    protected int numCedula;
    protected int codigoUnico;
    protected String usuario;
    protected String contrasenia;
    protected String correo; 

    public Usuario(String nombre, String apellido, int numCedula, String usuario, String contrasenia, String correo){
        this.apellido = apellido;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.nombre = nombre;
        this.numCedula = numCedula;
        this.usuario = usuario;
    }

    protected void consultarReserva(String fecha){

    }

    public abstract void gestionarReserva (String fecha);
/*
    public String toString() {
        return "Usuario{" +
               "nombre='" + nombre + '\'' +       
               ", apellido='" + apellido + '\'' +
               ", numCedula=" + numCedula +
               ", correo='" + correo + '\'' +
               '}';
    }
*/
    protected void enviarCorreo(String correoprofesor, TipoEspacio tipo,String materia ){
        System.out.println("Solicitud en proceso, se enviará un correo a profesor:" + correoprofesor);
        System.out.println("Tipo de espacio: " + tipo + ", Materia: " + materia);

    }
    protected void enviarCorreo(String destinatario, String cuerpo) {
        System.out.println("De: " + this.correo);
        System.out.println("Para: " + destinatario);
        System.out.println("Asunto: Reserva Realizada");
        System.out.println("Mensaje: " + cuerpo);
    }
    
    public void setNombres(String nombre){
        this.nombre = nombre;
    }

    public String getNombres(){
        return nombre;
    }

    public void setApellidos(String apellido){
        this.apellido = apellido;
    }

    public String getApellido(){
        return apellido;

    }
    public int getNumCedula(){
        return numCedula;
    }

    public void setNumCedula(int numCedula){
        this.numCedula = numCedula;
    }

    public int getCodigoUnico(){
        return codigoUnico;
    }

    public void setCodigoUnico(int codigoUnico){
        this.codigoUnico = codigoUnico;
    }

    public String getUsuario(){
        return usuario;
    }

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public String getContrasenia(){
        return contrasenia;
    }

    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }
}        
        
        




    


