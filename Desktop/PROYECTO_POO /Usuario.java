package POO5_1P_ZAMBRANO_PIZA_HUAYAMAVE;

public class Usuario {
    protected String nombre;
    protected String apellido;
    protected int numCedula;
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

    protected void gestionarReserva (String fecha){

    }

    protected void enviarCorreo(String profesor,Enum tipoEspacio,String materia ){

    }

    protected void enviarCorreo(String estudiante,Enum tipoEspacio, int matricula){

    }
}

