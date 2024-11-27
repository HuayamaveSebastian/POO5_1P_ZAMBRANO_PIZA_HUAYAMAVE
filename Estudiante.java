
import java.time.LocalDate;


public class Estudiante extends Usuario{

    private int matricula;
    private String carrera; 

    public Estudiante( String nombre, String apellido, String numCedula,String usuario, String contrasenia, String correo,int matricula, String carrera){
        super(nombre, apellido, numCedula, usuario, contrasenia, correo);
        this.matricula = matricula;
        this.carrera = carrera; 
    }

    public void setMatricula(int matricula){
        this.matricula = matricula;
    }

    public int getMatricula(){
        return matricula;
    }

    public void setCarrera(String carrera){
        this.carrera = carrera;
    }

    public String getCarrera (){
        return carrera; 
    }

    @Override
    public void gestionarReserva(LocalDate fecha ){
        System.out.println("Epere su confirmación");
        // ponerle mas cosas 
    }

    // ARREGLAR 
    @Override
    public void consultarReserva(LocalDate fecha){
        System.out.println(".....");
    }

}   