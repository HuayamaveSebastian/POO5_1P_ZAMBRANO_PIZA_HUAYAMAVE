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

    public cargo getCargo(){
        return cargo;
    }

    public void setCargo(){
        this.cargo = cargo;
    }

    
    public void gestionarReserva(List<Reserva> reservas) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Reservas pendientes:");
        for (Reserva reserva : reservas) {
            if (reserva.getEstado()== Estado.Pendiente){
                System.out.println("Codigo de reserva:" + reserva.getCodigoReserva());
                System.out.println(reseva.toString());
                System.out.println("Por favor, confirme la solicitud de reserva... (1: Aprobar, 2: Rechazar)");

                int decision = scanner.nextInt();
                scanner.nextLine(); 
                if (decision == 1) {
                    reserva.setEstado(Estado.Aprobado);
                    system.out.printlln("Su reserva ha sido Aprobada");
                }
                else if (decision ==2){
                    System.out.printlln("Describa el motivo de rechazo:");
                    String motivoRechazo = scanner.nextLine();
                    reserva.setEstado(Estado.Rechazado);
                    System.ouy.println("Su reserva ha sido Rechazda");
                }
                else{
                    System.out.println("Opcion no valida. Continue con la sigueinte reserva");
                }       
            }
        }
    }
    @Override  //Añadir la forma en que se consulta ya que es administrador
    public void consultarReserva(Date fecha){
        System.out.println("Consultar reservas para el dia:" = fecha);
    }

    @Override
    public String toString() {
        return "Administrador{" +
               "nombre='" + nombre + '\'' +
               ", apellido='" + apellido + '\'' +
               ", numCedula=" + numCedula + '\'' +
               ", usuario=" + usuario + '\'' +
               ", correo='" + correo + '\'' + 
               ", cargo=" + cargo +
               '}';
    }
}
