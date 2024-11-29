package com.proyectopoo;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

import com.proyectopoo.enums.TipoUsuario;
import com.proyectopoo.utilidades.SistemaCorreo;

public class Profesor extends Usuario{
    
    private ArrayList<String> Materias;
    private String Facultad;
    
    public Profesor (String nombre, String apellido,String codigoUsuario, String numCedula, String usuario, String contrasenia,String correo,String[] Materias, String Facultad){
        super(nombre,  apellido, codigoUsuario, numCedula, usuario, contrasenia, correo);
        this.Materias = new ArrayList<>(Arrays.asList(Materias));
        this.Facultad = Facultad;
        tipo = TipoUsuario.PROFESOR;
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
    public Reserva hacerReserva(Date fecha, EspacioUniversidad espacio, String motivo)
    {

        for (Administrador admin:Administrador.admins){
            String cabezera = "De: " + this.correo + "\nPara: " + admin.correo;
            String mensaje = "\n\nSe le notifica que el profesor " + this.nombre + " " + this.apellido + "\r\n" + 
            "ha realizado una reserva con código " + this.codigoUnico + "\r\n" + //
            "para la fecha " + fecha +" en el " +espacio.getNombre() + " \r\n" + //
             "para la materia " + motivo;  //

            String mensajeFinal = cabezera + mensaje;
            SistemaCorreo.generarCorreo(this.correo, admin.correo, "Reserva realizada", mensajeFinal);
        }

        return super.hacerReserva(fecha, espacio, motivo);

    }
    

    public ArrayList<String> getMaterias(){
        return Materias;
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

