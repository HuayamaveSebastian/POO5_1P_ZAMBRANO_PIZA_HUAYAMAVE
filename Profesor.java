import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import Enums.TipoEspacio;

public class Profesor extends Usuario{
    
    private ArrayList<String> materias;
    private String facultad;
    
    public Profesor (String nombre, String apellido, String numCedula, String usuario, String contrasenia, String correo, List<String> materias, String facultad){
        super(nombre, apellido, numCedula, usuario, contrasenia, correo);
        this.materias = materias != null? new ArrayList<>(materias) : new ArrayList<>();
        this.facultad = facultad;
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
        System.out.println("Consultando la reserva del profesor" + this.nombre + "para la fecha" + fecha);
    }

    @Override
    public void gestionarReserva( Date fecha){
        System.out.println("Gestionando reservas del profesor" + this.nombre + "para la fecha:" + fecha);

    }

    public List<Strings> getMaterias(){
        return materias;
    }

    public void setMaterias(List<String> materias) {
        this.materias = materiales != null ? new ArrayList<>(materias);
    }

    public String getFacultad(){
        return facultad;
    }

    public void setFacultad(String facultad){
        this.facultad = facultad;
    }
    
    @Override
    public String toString() {
    return "Profesor{" +
           "nombre='" + nombre + '\'' +
           ", apellido='" + apellido + '\'' +
           ", numCedula=" + numCedula +
           ", usuario='" + usuario + '\'' +
           ", correo='" + correo + '\'' +
           ", facultad='" + facultad + '\'' +
           ", materias=" + materias +
           '}';
    }
} 

