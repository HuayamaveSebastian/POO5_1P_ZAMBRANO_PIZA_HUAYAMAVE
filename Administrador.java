import java.util.List;
import java.util.Scanner;
import com.example.*;
import com.example.Enums.*;
public class Administrador extends Usuario {
    
 private Cargo cargo;

    public Administrador(String nombre, String apellido, int numCedula, String usuario, String contrasenia,String correo, Cargo cargo){
        super(nombre, apellido, numCedula, usuario, contrasenia, correo);
        this.cargo = cargo;

    }
    @Override
    public void gestionarReserva(List<Reserva> reservas) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Reservas pendientes:");
        for (Reserva reserva : reservas) {
            if (reserva.getEstado().equals("PENDIENTE")) {
                System.out.println(reserva);
            }
        }
    }
    @Override
    public void consultarReserva(String fecha){
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
