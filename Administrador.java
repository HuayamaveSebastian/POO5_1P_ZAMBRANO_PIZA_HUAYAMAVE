import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import Enums.*;
public class Administrador extends Usuario {
    
 private Cargo cargo;

    public Administrador(String nombre, String apellido, String numCedula, String usuario, String contrasenia,String correo, Cargo cargo){
        super(nombre, apellido, numCedula, usuario, contrasenia, correo);
        this.cargo = cargo;

    }
    
    public void gestionarReserva(List<Reserva> reservas) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Reservas pendientes:");
        for (Reserva reserva : reservas) {
            if (reserva.getEstado().equals("PENDIENTE")) {
                System.out.println(reserva);
            }
        }
    }
    @Override  //Añadir la forma en que se consulta ya que es administrador
    public void consultarReserva(Date fecha){
        System.out.println("Consultar Reserva");
    }

    @Override
    public String toString() {
        return "Administrador{" +
               "nombre='" + nombre + '\'' +
               ", apellido='" + apellido + '\'' +
               ", numCedula=" + numCedula +
               ", correo='" + correo + '\'' +
               '}';
    }
}
