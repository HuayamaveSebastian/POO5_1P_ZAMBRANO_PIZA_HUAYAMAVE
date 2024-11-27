import com.example.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class GestionarReserva {


    static Usuario personUsuario = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.println("Ingrese usuario:"); 
        String usuario = sc.next();
        System.out.println("Ingrese su contraseña:");
        String contrasenia = sc2.next(); 

        boolean logeado = false;
        
        while (personUsuario == null){
            try {
                FileReader fr = new FileReader("usuarios.txt");
                BufferedReader br = new BufferedReader(fr);
                String linea;
                ArrayList<String> lineas = new ArrayList<String>();
        
                try {
                    while ((linea = br.readLine())!= null){
                        lineas.add(linea);
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                
                

                for (String dato:lineas){
                    String[] lineaDato = dato.split("\\|");
                    String codigo = lineaDato[0].trim();
                    String cedula = lineaDato[1].trim();
                    String nombre = lineaDato[2].trim();
                    String apellido = lineaDato[3].trim();
                    String userDato = lineaDato[4].trim();
                    String contraseniaDato = lineaDato[5].trim();
                    String email = lineaDato[6].trim();
                    String tipo = lineaDato[7].trim();

                    if (usuario.equals(userDato) && contrasenia.equals(contraseniaDato)){
                        System.out.println("Usuario correcto. Bienvenido!");
                        logeado = true;

                        switch(tipo){
                            case "E":
                                personUsuario = new Estudiante(nombre, userDato, cedula, usuario, contraseniaDato, email, 0, tipo);
                                try {
                                FileReader fre = new FileReader("estudiantes.txt");
                                BufferedReader bre = new BufferedReader(fre);
                                String lineae;
                                ArrayList<String> linease = new ArrayList<String>();
                            
                                    try {
                                        while ((lineae = bre.readLine())!= null){
                                            linease.add(lineae);
                                        }
                                    } catch (IOException ee) {
                                        System.out.println(ee.getMessage());
                                    }
                                    for (String datoe:linease){
                                        String[] lineaDatoe = datoe.split("\\|");
                                        String codigoe = lineaDatoe[0].trim();
                                        String cedulae = lineaDatoe[1].trim();
                                        String nombree = lineaDatoe[2].trim();
                                        String apellidoe = lineaDatoe[3].trim();
                                        String matricula = lineaDatoe[4].trim();
                                        String carrerae = lineaDatoe[5].trim();
                                    }
                                    
                                }   catch (Exception ee) {}
                                break;
                            case "P":
                                personUsuario = new Profesor(nombre, apellido, cedula, usuario, contraseniaDato, email, lineas, tipo);
                                try {
                                    FileReader frp = new FileReader("profesores.txt");
                                    BufferedReader brp = new BufferedReader(frp);
                                    String lineap;
                                    ArrayList<String> lineasp = new ArrayList<String>();
                                
                                        try {
                                            while ((lineap = brp.readLine())!= null){
                                                lineasp.add(lineap);
                                            }
                                        } catch (IOException ep) {
                                            System.out.println(ep.getMessage());
                                        }
                                        for (String datoe:lineasp){
                                            String[] lineaDatoe = datoe.split("\\|");
                                            String codigop = lineaDatoe[0].trim();
                                            String cedulap = lineaDatoe[1].trim();
                                            String nombrep = lineaDatoe[2].trim();
                                            String apellidop = lineaDatoe[3].trim();
                                            String facultad = lineaDatoe[4].trim();
                                            String materias = lineaDatoe[5].trim();
                                        }
                                        
                                    }   catch (Exception ep) {}
                                break;

                            case "A":
                                personUsuario = new Administrador(nombre, apellido, cedula, usuario, contraseniaDato, tipo, null);
                                try {
                                    FileReader fra = new FileReader("administradores.txt");
                                    BufferedReader bra = new BufferedReader(fra);
                                    String lineap;
                                    ArrayList<String> lineasa = new ArrayList<String>();
                                
                                        try {
                                            while ((lineap = bra.readLine())!= null){
                                                lineasa.add(lineap);
                                            }
                                        } catch (IOException ea) {
                                            System.out.println(ea.getMessage());
                                        }
                                        for (String datoe:lineasa){
                                            String[] lineaDatoe = datoe.split("\\|");
                                            String codigop = lineaDatoe[0].trim();
                                            String cedulap = lineaDatoe[1].trim();
                                            String nombrep = lineaDatoe[2].trim();
                                            String apellidop = lineaDatoe[3].trim();
                                            String  cargo = lineaDatoe[4].trim();
                                        }
                                        
                                    }   catch (Exception ea) {}
                                break;
                        
                        }
                        break;

                    }

                }

                if (!logeado){
                    System.out.println("Credenciales incorrectas");
                    break;
                    }
                
                } catch (Exception e) {
            }
        }

    }

    // falta hacer el menu para el tipo de usuario
}
