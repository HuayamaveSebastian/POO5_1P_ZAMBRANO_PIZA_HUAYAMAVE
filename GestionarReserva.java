import java.io.*;
import java.util.*;
import com.example.*;

public class GestionarReserva {

    public static void main(String[] args) {
        // Cargar usuarios desde el archivo
        List<Usuario> usuarios = leerUsuarios("usuarios.txt");

        // Enviar correos a los usuarios
        for (Usuario usuario : usuarios) {
            // Verificar el tipo de usuario para enviar el correo correspondiente
            if (usuario instanceof Profesor) {
                Profesor profesor = (Profesor) usuario;
                // Ejemplo de enviar correo al administrador sobre la reserva
                profesor.enviarCorreoReserva("admin@uni.edu", "Aula Magna", "2024-11-10", "Matemáticas");
            } else if (usuario instanceof Estudiante) {
                Estudiante estudiante = (Estudiante) usuario;
                // Ejemplo de enviar correo al administrador sobre la reserva
                estudiante.enviarCorreoReserva("admin@uni.edu", "Cancha de Futbol", "2024-11-11", "Estudio grupal");
            }
        }
    }

    // Método para leer usuarios desde un archivo
    public static List<Usuario> leerUsuarios(String rutaArchivo) {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                int codigoUnico = Integer.parseInt(partes[0].trim());
                int numCedula = Integer.parseInt(partes[1].trim());
                String nombre = partes[2].trim();
                String apellido = partes[3].trim();
                String usuario = partes[4].trim();
                String contrasenia = partes[5].trim();
                String correo = partes[6].trim();
                String rol = partes[7].trim();

                // Crear un objeto según el rol
                switch (rol) {
                    case "E": // Estudiante
                        usuarios.add(new Estudiante(nombre, apellido, numCedula, usuario, contrasenia, correo, codigoUnico, "Ingeniería"));
                        break;
                    case "P": // Profesor
                        usuarios.add(new Profesor(nombre, apellido, numCedula, usuario, contrasenia, correo, List.of("Matemáticas"), "Facultad de Ciencias"));
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return usuarios;
    }
}
