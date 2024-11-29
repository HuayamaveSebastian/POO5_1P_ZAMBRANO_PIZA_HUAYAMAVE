package com.proyectopoo;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import com.proyectopoo.enums.Cargo;
import com.proyectopoo.enums.EspacioPermiso;
import com.proyectopoo.enums.EstadoReserva;
import com.proyectopoo.enums.TipoEspacio;
import com.proyectopoo.utilidades.ManejoArchivos;
import com.proyectopoo.utilidades.SistemaCorreo;

public abstract class Main
{
    static Usuario personUsuario = null;


    static Scanner sc;



    public static void main(String[] args) 
    {
        EspacioUniversidad.espacios = EspacioUniversidad.obtenerEspacios();
        Reserva.reservas = Reserva.obtenerReservas();
        Administrador.admins = Administrador.obtenerAdmins();

        sc = new Scanner(System.in);

        mostrarLogin();

        if (personUsuario != null)
            SistemaCorreo.init();


        while (personUsuario != null)
        {
            mostrarMenu();
        }
    }

    /**
     * Muestra el login para que el cliente ingrese su usuario y contraseña
     */
    private static void mostrarLogin()
    {
        System.out.println("Ingrese usuario:"); 
        String usuario = sc.next();
       
        System.out.println("Ingrese su contraseña:");
        String contrasenia = sc.next(); 

        personUsuario = validarLogin(usuario,contrasenia);

        if (personUsuario == null)
        {
            System.out.println("Credenciales incorrectas\n");
            mostrarLogin();
        }
        else
            System.out.println("Usuario correcto. Bienvenido!");
    }

    /**
     * Valida las credenciales ingresadas por el cliente
     * @param usuario el nombre de usuario
     * @param contrasenia la contraseña
     * @return el usuario generado por estas credenciales
     */
    private static Usuario validarLogin(String usuario, String contrasenia)
    {
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("usuarios.txt");      

        for (String dato:lineas)
        {
            String[] lineaDato = dato.split("\\|");
            String codigo = lineaDato[0].trim();
            String cedula = lineaDato[1].trim();
            String nombre = lineaDato[2].trim();
            String apellido = lineaDato[3].trim();
            String userDato = lineaDato[4].trim();
            String contraseniaDato = lineaDato[5].trim();
            String email = lineaDato[6].trim();
            String tipo = lineaDato[7].trim();


            if (usuario.equals(userDato) && contrasenia.equals(contraseniaDato))
            {
                switch(tipo.charAt(0))
                {
                    case 'E':
                        ArrayList<String> linease = ManejoArchivos.LeeFichero("estudiantes.txt");

                        System.out.println("Estudiante");

                        for (String datoe:linease)
                        {
                            String[] lineaDatoe = datoe.split("\\|");
                            String codigoe = lineaDatoe[0].trim();
                            String cedulae = lineaDatoe[1].trim();
                            String matricula = lineaDatoe[4].trim();
                            String carrerae = lineaDatoe[5].trim();

                            if (cedulae.equals(cedula)  && codigoe.equals(codigo))
                                return new Estudiante(nombre, apellido, codigo, cedula, usuario, contraseniaDato, email, matricula, carrerae);
                            
                        }

                        

                        break;

                    case 'P':
                        

                        ArrayList<String> lineasp = ManejoArchivos.LeeFichero("profesores.txt");


                        for (String datoe:lineasp)
                        {
                            String[] lineaDatoe = datoe.split("\\|");
                            String codigop = lineaDatoe[0].trim();
                            String cedulap = lineaDatoe[1].trim();
                            String facultad = lineaDatoe[4].trim();
                            String[] materias = lineaDatoe[5].split(",");


                            if (cedulap.equals(cedula)  && codigop.equals(codigo))                         
                                return new Profesor(nombre, apellido, codigo, cedula, usuario, contraseniaDato, email, materias, facultad);
                            
                        }

                        break;



                    case 'A':


                        ArrayList<String> lineasa = ManejoArchivos.LeeFichero("administradores.txt");


                        for (String datoe:lineasa)
                        {
                            String[] lineaDatoe = datoe.split("\\|");
                            String codigoa = lineaDatoe[0].trim();
                            String cedulaa = lineaDatoe[1].trim();
                            String  cargo = lineaDatoe[4].trim();

                            Cargo enumCargo;

                            switch(cargo){
                                case "INGENIERO DE DATOS":
                                    enumCargo = Cargo.INGENIERODEDATOS;
                                    break;
                                case "ANALISTA":
                                    enumCargo = Cargo.ANALISTA;
                                    break;
                                case "TECNICO DE INFRAESTRUCTURA":
                                    enumCargo = Cargo.TECNICODEINFRAESTRUCTURA;
                                    break;
                                default:
                                    enumCargo = Cargo.INGENIERODEDATOS;
                                    break;
                            }

                            if (cedulaa.equals(cedula)  && codigoa.equals(codigo))                           
                                return new Administrador(nombre, apellido,codigo, cedula, usuario, contraseniaDato, email, enumCargo);

                            
                        }

                        break;
                                
                }


            }

        }

        return null;
    }

    /**
     * Muestra el menu dependiendo del tipo de usuario si es que el usuario se ha logeado correctamente
     */
    private static void mostrarMenu()
    {
        int opcion = -1;

        System.out.println("Opciones:\n");
        switch (personUsuario.tipo)
        {
            case ESTUDIANTE, PROFESOR: 
                System.out.println("1. Reservar"); 
                System.out.println("2. Consultar reserva\n");
                System.out.println("Ingrese opcion: ");
                opcion = sc.nextInt();

                switch(opcion)
                {
                    case 1:
                        mostrarMenuReserva();
                        break;
                    case 2:
                        mostrarConsultas();
                        break;
                    default:

                }
                break;

            case ADMINISTRADOR:
                System.out.println("1. Gestionar reserva"); 
                System.out.println("2. Consultar reserva\n");
                System.out.println("Ingrese opcion: ");
                opcion = sc.nextInt();

                switch(opcion)
                {
                    case 1:
                        mostrarMenuGestion();
                        break;
                    case 2:
                        mostrarConsultas();
                        break;
                    default:
                }
                break;
                
        }

        
        
    }

    private static void mostrarMenuReserva()
    {
        int opcion = -1;
        String fecha;
        System.out.println("Ingrese la fecha que quiere reservar:"); 
        fecha = sc.next();

        System.out.println(personUsuario.tipo);

        switch(personUsuario.tipo)
        {
            case ESTUDIANTE:
                System.out.println("Elija el espacio a reservar:"); 
                System.out.println("1. Cancha");
                System.out.println("2. Aula");
                System.out.println("Ingrese opcion: ");
                opcion = sc.nextInt();
                TipoEspacio tipoEspacio = opcion == 1 ? TipoEspacio.CANCHA: TipoEspacio.AULA;
                ArrayList<EspacioUniversidad> espacios = EspacioUniversidad.buscarEspacios(EspacioPermiso.ESTUDIANTE, tipoEspacio);
                System.out.println();
                int indice = 1;
                for (EspacioUniversidad espacio:espacios){
                    System.out.println(indice + ". " + espacio);
                    indice++;
                }

                int opcionLugar = -1;

                while (true)
                {
                    System.out.println("Ingrese el lugar que quiere reservar: ");
                    opcionLugar = sc.nextInt();


                    if (opcionLugar > 0 && opcionLugar <= espacios.size())
                    {
                        System.out.println("Ingrese el motivo de la reserva: ");
                        String motivo = sc.next();

                        EspacioUniversidad espacioElegido = espacios.get(opcionLugar-1);
                        personUsuario.hacerReserva(Date.valueOf(fecha), espacioElegido, motivo);
                        break;
                    }
                }
                break;


            case PROFESOR:
                System.out.println("Elija el espacio a reservar:"); 
                System.out.println("1. Aula");
                System.out.println("2. Laboratorio");
                System.out.println("3. Auditorio");
                System.out.println("Ingrese opcion: ");
                opcion = sc.nextInt();
                System.out.println(opcion);
                switch(opcion)
                {
                    case 1:
                        tipoEspacio = TipoEspacio.AULA;
                        break;
                    case 2:
                        tipoEspacio = TipoEspacio.LABORATORIO;
                        break;
                    case 3:
                        tipoEspacio = TipoEspacio.AUDITORIO;
                        break;
                    default:
                        tipoEspacio = TipoEspacio.AULA;
                        break;
                }

                espacios = EspacioUniversidad.buscarEspacios(EspacioPermiso.PROFESOR, tipoEspacio);
                System.out.println();
                indice = 1;
                for (EspacioUniversidad espacio:espacios){
                    System.out.println(indice + ". " + espacio);
                    indice++;
                }

                opcionLugar = -1;

                while (true)
                {
                    System.out.println("Ingrese el lugar que quiere reservar: ");
                    opcionLugar = sc.nextInt();


                    if (opcionLugar > 0 && opcionLugar <= espacios.size())
                    {
                        while (true)
                        {
                            System.out.println("Ingrese la materia del espacio a reservar: ");
                            if (personUsuario instanceof Profesor)
                            {
                                Profesor profe = (Profesor) personUsuario;
                                indice = 1;

                                for (String materia:profe.getMaterias())
                                {
                                    System.out.println(indice + ". " + materia);
                                    indice++;
                                }
                                System.out.println("Ingrese opcion: ");
                                int opcionMateria = sc.nextInt();
                                if (opcionMateria > 0 && opcionMateria <= profe.getMaterias().size())
                                {
                                    EspacioUniversidad espacioElegido = espacios.get(opcionMateria-1);
                                    Reserva reserva = personUsuario.hacerReserva(Date.valueOf(fecha), espacioElegido, profe.getMaterias().get(opcionMateria-1));
                                    reserva.setEstado(EstadoReserva.APROBADO);
                                    break;
                                }
                            }
                           
                        }


                        break;
                    }
                }
                break;

            default:
        }
    }

    private static void mostrarMenuGestion()
    {
        if (!(personUsuario instanceof Administrador))
            return;

        Reserva reserva = null;
        Administrador administrador = (Administrador) personUsuario;

        System.out.println("Ingrese el numero de la reserva:"); 
        int codigo = sc.nextInt();
        reserva = Reserva.obtenerReservaPorCodigo(codigo);
        if (reserva == null)
        {
            System.out.println("Reserva no encontrada!");
            mostrarMenuGestion();
        }
        else
        {
            System.out.println("Datos de la reserva: ");
            System.out.println(reserva);
            System.out.println("\nOpciones de Reserva: ");
            System.out.println("1. APROBAR");
            System.out.println("2. RECHAZAR");
            System.out.println("3. EN PENDIENTE");
            System.out.println("Elija una opcion: ");
            int opcion = sc.nextInt();
            String motivo = "";
            EstadoReserva estado;
            switch(opcion){
                case 1:
                    estado = EstadoReserva.APROBADO;
                    break;
                case 2:
                    estado = EstadoReserva.RECHAZADO;
                    System.out.println("Redacte el motivo del rechazo: ");
                    motivo = sc.next();
                    break;

                default:
                    estado = EstadoReserva.PENDIENTE;
                    break;
            }

            if (opcion > 0 && opcion <= 2)
                administrador.gestionarReserva(reserva,estado,motivo);
        }
        

    }

    private static void mostrarConsultas()
    {
        System.out.println("Ingrese la fecha que quiere consultar:"); 
        String fecha = sc.next();

        ArrayList<Reserva> reservas = Reserva.obtenerReservasPorFecha(fecha);

        System.out.println("===========================================================");
        
        for (Reserva reserva:reservas)
            System.out.println(reserva);
        
        System.out.println("==========================================================="); 

    }

    


    // el Scanner no se cierra porque al finalizar el programa se cierra automatico al ser static
}
