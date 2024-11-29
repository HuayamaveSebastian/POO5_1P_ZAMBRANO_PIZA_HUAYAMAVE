package com.proyectopoo;
import java.sql.Date;

import com.proyectopoo.enums.TipoUsuario; //no se si se va a usar localdate pero igual para que cuadre lo cambié
import com.proyectopoo.utilidades.SistemaCorreo;

public class Estudiante extends Usuario{

    private String matricula;
    private String carrera; 

    public Estudiante( String nombre, String apellido, String codigoUsuario,String numCedula,String usuario, String contrasenia, String correo,String matricula, String carrera){
        super(nombre, apellido, codigoUsuario,numCedula, usuario, contrasenia, correo);
        this.matricula = matricula;
        this.carrera = carrera; 
        tipo = TipoUsuario.ESTUDIANTE;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public String getMatricula(){
        return matricula;
    }

    public void setCarrera(String carrera){
        this.carrera = carrera;
    }

    public String getCarrera (){
        return carrera; 
    }

    @Override
    public Reserva hacerReserva(Date fecha, EspacioUniversidad espacio, String motivo)
    {
        for (Administrador admin:Administrador.admins){
            String cabezera = "De: " + this.correo + "\nPara: " + admin.correo;
            String mensaje = "\n\nEl estudiante " + this.nombre + " " + this.apellido + "\r\n" + 
            "ha realizado una reserva con código " + this.codigoUnico + "\r\n" + //
            "para la fecha " + fecha +" en el " +espacio.getNombre() + " \r\n" + //
             "Ingrese al sistema para APROBAR o RECHAZAR la reserva.";  //

            String mensajeFinal = cabezera + mensaje;
            SistemaCorreo.generarCorreo(this.correo, admin.correo, "Reserva realizada", mensajeFinal);
        }

        return super.hacerReserva(fecha, espacio, motivo); // Retornar el metodo porque este devuelve una reserva tmb
    }
}   
