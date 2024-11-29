import java.sql.Date;
import java.time.LocalDate; //no se si se va a usar localdate pero igual para que cuadre lo cambié


public class Estudiante extends Usuario{

    private int matricula;
    private String carrera; 

    public Estudiante( String nombre, String apellido, String numCedula,String usuario, String contrasenia, String correo,int matricula, String carrera){
        super(nombre, apellido, numCedula, usuario, contrasenia, correo);
        this.matricula = matricula;
        this.carrera = carrera; 
    }
    
    @Override   
    public void consultarReserva( Date fecha ){
        System.out.println("El Estudiante" + this.nombre + "está consultando reservas para el dia:" + fecha);
    }

    @Override
    public void gestionarReserva(Date fecha ){
        System.out.println("El Estudiante" + this.nombre + " está modificando su reserva para el día:" + fecha);
    }

    
    public int getMatricula(){
        return matricula;
    }
    
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }

    public String getCarrera (){
        return carrera; 
    }

    public void setCarrera(String carrera){
        this.carrera = carrera;
    }
    
    @Override
    public String toString(){
        return "Estudiuante{" +
            "nombre=" + nombre + '\'' +
            ", apellido='" + apellido + '\'' +
                ", matricula=" + matricula +
                ", carrera='" + carrera + '\'' +
                ", usuario='" + usuario + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}   
