import java.util.Date;

import Enums.TipoEspacio;

public abstract class Usuario {
    protected String nombre;
    protected String apellido;
    protected String numCedula;   //Considero que es String por el hecho de que son numeros excesivos comenzando desde el 0.
    protected String usuario;
    protected String contrasenia;
    protected String correo; 

    public Usuario(String nombre, String apellido, String numCedula, String usuario, String contrasenia, String correo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.numCedula = numCedula;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.correo = correo;
    }

    public abstract void consultarReserva(Date fecha); //Este deberia ir como abstract debido a que se repite en los tres pero funciona diferente

    public abstract void gestionarReserva (Date fecha){

    }

    protected void enviarCorreo(String correoprofesor, TipoEspacio tipo,String materia ){
        System.out.println("Solicitud en proceso, se enviará un correo al profesor:" + correoprofesor);
        System.out.println("De: " + this.correo);
        System.out.println("Asunto: Notificacion de Reserva");
        System.out.println("Mensaje:");
        System.out.println("Se solicitó el uso del siguiente espacio:" + tipo);
        System.out.println("Materia relacionada:" + materia);
        System.out.println("Por favor, revise y gestione dicha solicitud");

    }
    protected void enviarCorreo(String destinatario, String cuerpo) {
        System.out.println("Sistema de envios de correo en proceso");
        System.out.println("De: " + this.correo);
        System.out.println("Para: " + destinatario);
        System.out.println("Asunto: Notificacion del sistema");
        System.out.println("Mensaje: ");
        System.out.println(cuerpo);
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellidos(String apellido){
        this.apellido = apellido;
    }
    
    public String getNumCedula(){
        return numCedula;
    }

    public void setNumCedula(String numCedula){
        this.numCedula = numCedula;
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

    @Override
    public String toString() {
        return "Usuario{" +
               "nombre='" + nombre + '\'' +       
               ", apellido='" + apellido + '\'' +
               ", numCedula=" + numCedula + '\'' +
               ", usuario=" + usuario + '\'' +
               ", correo='" + correo + '\'' +
               '}';
    }
}        
        
        

        




    


