import java.sql.Date;

import Enums.*;

public abstract class Usuario {
    protected String nombre;
    protected String apellido;
    protected String numCedula;   //Considero que es String por el hecho de que son numeros excesivos comenzando desde el 0.
    protected int codigoUnico;
    protected String usuario;
    protected String contrasenia;
    protected String correo; 

    public Usuario(String nombre, String apellido, String numCedula, String usuario, String contrasenia, String correo){
        this.apellido = apellido;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.nombre = nombre;
        this.numCedula = numCedula;
        this.usuario = usuario;
    }

    abstract void consultarReserva(Date fecha); //Este deberia ir como abstract debido a que se repite en los tres pero funciona diferente

    protected void gestionarReserva (Date fecha){

    }
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
    public String getNumCedula(){
        return numCedula;
    }

    public void setNumCedula(String numCedula){
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
        
        

        




    


