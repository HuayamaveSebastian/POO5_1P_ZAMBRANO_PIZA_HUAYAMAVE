package com.proyectopoo;

import java.sql.Date;
import java.util.ArrayList;

import com.proyectopoo.enums.EstadoReserva;
import com.proyectopoo.enums.TipoEspacio;
import com.proyectopoo.utilidades.ManejoArchivos;


public class Reserva {
    private Date fechaReserva;
    private String cedula;
    private int codigoReserva;
    private String codigoUsuario;
    private int codigoEspacio;
    private TipoEspacio tipo;
    private EstadoReserva estado;
    private String motivo;
    private static int contadorReservas;

    public static ArrayList<Reserva> reservas;
    
    // Constructor para reserva hecha por el usuario
    public Reserva(String codigoUsuario, String cedula, Date fechaReserva, int codigoEspacio, TipoEspacio tipo, String motivo) 
    {
        this.fechaReserva = fechaReserva;
        this.cedula = cedula;
        this.codigoReserva = generaCodigo();
        this.codigoUsuario = codigoUsuario;
        this.codigoEspacio = codigoEspacio;
        this.tipo = tipo;
        this.estado = EstadoReserva.PENDIENTE; 
        this.motivo = motivo;
        contadorReservas++;
    }

    // Reserva generada por el archivo reservas.txt - ya estan en el archivo
    public Reserva(int codigoReserva,String codigoUsuario, String cedula, Date fechaReserva, int codigoEspacio, TipoEspacio tipo, EstadoReserva estado, String motivo)
    {
        this.fechaReserva = fechaReserva;
        this.cedula = cedula;
        this.codigoUsuario = codigoUsuario;
        this.codigoEspacio = codigoEspacio;
        this.codigoReserva = codigoReserva;
        this.tipo = tipo;
        this.estado = estado; 
        this.motivo = motivo;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public int getCodigoReserva() {
        return codigoReserva;
    }

    public TipoEspacio getTipo() {
        return tipo;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public int generaCodigo()
    {
        return contadorReservas;
    }

    public String getCedula(){
        return cedula;
    }

    public int getCodigoEspacio(){
        return codigoEspacio;
    }

    public String getCodigoUsuario()
    {
        return codigoUsuario;
    }

    public String toString(){
        return "Codigo de Reserva: " + codigoReserva + " | Codigo Espacio: " + getCodigoEspacio() + "| Tipo Espacio: " + tipo + " | Cedula: " + cedula + " | Codigo Usuario: " + codigoUsuario + "| MOTIVO: " + motivo + " | ESTADO: " + estado;
    }

    public static ArrayList<Reserva> obtenerReservas()
    {
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("reservas.txt");
        ArrayList<Reserva> listaReservas = new ArrayList<>();

        for (String linea:lineas)
        {
            String[] lineaDato = linea.split("\\|");
            Integer codigoReserva = Integer.valueOf(lineaDato[0].trim());
            String codigoUsuario = lineaDato[1].trim();
            String cedula = lineaDato[2].trim();
            Date fecha = Date.valueOf(lineaDato[3].trim());

            Integer codigoUnicoReservado = Integer.valueOf(lineaDato[4].trim());
            TipoEspacio tipoEspacio = TipoEspacio.valueOf(lineaDato[5].trim());
            EstadoReserva estado = EstadoReserva.valueOf(lineaDato[6].trim());
            String motivo = lineaDato[7].trim();

            listaReservas.add(new Reserva(codigoReserva, codigoUsuario, cedula, fecha, codigoUnicoReservado, tipoEspacio, estado, motivo));
            
        }

        contadorReservas = listaReservas.get(listaReservas.size()-1).codigoReserva+1;

        return listaReservas;
    }

    public static ArrayList<Reserva> obtenerReservasPorFecha(String fecha)
    {
        ArrayList<Reserva> listaReservas = (ArrayList<Reserva>) reservas.clone();

        Date date = Date.valueOf(fecha);

        listaReservas.removeIf(reserva->!reserva.fechaReserva.equals(date));

        return listaReservas;

    }

    public static Reserva obtenerReservaPorCodigo(int codigo)
    {


        for (Reserva reserva:reservas){
            if (reserva.getCodigoReserva() == codigo && reserva.getEstado() == EstadoReserva.PENDIENTE)
                return reserva;
        }


        return null;
    }

    public static void actualizarArchivoReservas()
    {
        ArrayList<Reserva> listaReservas = (ArrayList<Reserva>) reservas;
        
        boolean primeraLinea = false;

        for (Reserva reserva:listaReservas)
        {
            String linea = reserva.getCodigoReserva() + " | " + reserva.getCodigoUsuario() + " | " + reserva.getCedula() + " | " + reserva.getFechaReserva() + " | " +  reserva.getCodigoEspacio() + " | " + reserva.getTipo() + " | " + reserva.getEstado() + " | " + reserva.getMotivo(); 
            ManejoArchivos.EscribirArchivo("reservas.txt", linea,primeraLinea);
            primeraLinea = true;
        }
    }
}
