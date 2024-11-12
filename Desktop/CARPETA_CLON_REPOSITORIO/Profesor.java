import com.example.Usuario;

    public class Profesor extends Usuario{
    
    private String Materias;
    private String Facultad;
    
    public Profesor (String nombre, String apellido, int numCedula, String usuario, String contrasenia,String correo,String Materias, String Facultad){
        super(nombre, apellido, numCedula, usuario, contrasenia, correo);
        this.Materias = Materias;
        this.Facultad = Facultad;
    }

    public void consultarReserva(String fecha){
        
    }

    public void gestionarReserva(String fecha){

    }
} 

