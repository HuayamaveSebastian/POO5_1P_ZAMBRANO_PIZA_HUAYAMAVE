import com.example.*;;

public class Administrador extends Usuario {
    
    private Cargo cargo;

    public Administrador(String nombre, String apellido, int numCedula, String usuario, String contrasenia,String correo, Cargo cargo){
        super(nombre, apellido, numCedula, usuario, contrasenia, correo);
        this.cargo = cargo;

    }

    public void consultarReserva(String fecha){
        
    }

    public void gestionarReserva(String fecha){

    }

}
