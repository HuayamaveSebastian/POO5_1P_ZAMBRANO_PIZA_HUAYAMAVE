import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import Enums.TipoEspacio;

public class Profesor extends Usuario{
    
    private ArrayList<String> Materias;
    private String Facultad;
    
    public Profesor (String nombre, String apellido, String numCedula, String usuario, String contrasenia, String correo, List<String> Materias, String Facultad){
        super(nombre, apellido, numCedula, usuario, contrasenia, correo);
        this.Materias = new ArrayList<>(Materias);
        this.Facultad = Facultad;
    }
    
    public void enviarCorreoReserva(String destinatario, String nombreEspacio, String fecha, String materia) {
        String cuerpo = "Se le notifica que el profesor " + this.nombre + " " + this.apellido +
                        " ha realizado una reserva para la fecha " + fecha +
                        " en el espacio " + nombreEspacio + " para la materia " + materia + ".";
        enviarCorreo(destinatario, cuerpo);
    }
/* 
    public void enviarCorreoReserva(String destinatario, String nombreEspacio, String fecha, String motivo) {
        
        String cuerpo = "El estudiante " + this.nombre + " " + this.apellido +
                        " ha realizado una reserva con código" + codigo + "para la fecha " + fecha +
                        " en la cancha " + nombreEspacio + ".Ingrese al sistema para aprobar o rechazar la reserva."  ;
        enviarCorreo(destinatario, cuerpo);
    }
*/
    @Override
    public void consultarReserva( Date fecha){
        System.out.println("Consultando la reserva del profesor")
        
    }

    public void gestionarReserva( Date fecha){
        System.out.println("Gestion de reserva en proceso")

    }
    @Override
    public String toString() {
    return "Profesor{" +
           "nombre='" + nombre + '\'' +
           ", apellido='" + apellido + '\'' +
           ", numCedula=" + numCedula +
           ", correo='" + correo + '\'' +
           '}';
    }
} 

