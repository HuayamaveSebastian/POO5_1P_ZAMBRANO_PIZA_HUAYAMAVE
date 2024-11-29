package com.proyectopoo;

import java.util.ArrayList;

import com.proyectopoo.enums.Cargo;
import com.proyectopoo.enums.EstadoReserva;
import com.proyectopoo.enums.TipoUsuario;
import com.proyectopoo.utilidades.SistemaCorreo;
public class Administrador extends Usuario {
    
    private Cargo cargo;

    public static ArrayList<Administrador> admins;

    public Administrador(String nombre, String apellido, String codigoUsuario,String numCedula, String usuario, String contrasenia,String correo, Cargo cargo){
        super(nombre, apellido,codigoUsuario, numCedula, usuario, contrasenia, correo);
        this.cargo = cargo;
        tipo = TipoUsuario.ADMINISTRADOR;

    }
    
    public void gestionarReserva(Reserva reserva, EstadoReserva estado, String motivo) 
    {
        if (reserva == null || estado == EstadoReserva.PENDIENTE)
            return;
        
        reserva.setEstado(estado);
        Reserva.actualizarArchivoReservas();

        Usuario user = Usuario.obtenerUsuarioPorCodigo(reserva.getCodigoUsuario());

        if (user == null)
            return;
            
        String mensaje = "";
        String tema = "";
        switch(estado)
        {
            case APROBADO:
                tema = "Reserva aprobada";
                mensaje =  "\n\nSe ha APROBADO su reserva con código " + reserva.getCodigoReserva() + ".\nAtentamente, Departamento Administrativo";
                break;
            case RECHAZADO:
                tema = "Reserva rechazada";
                mensaje = "\n\nSe ha RECHAZADO su reserva con código " + reserva.getCodigoReserva() + " por el siguiente motivo: " + motivo + ".\n Atentamente, Departamento Administrativo";
                break;
        }

        String cabezera = "De: " + this.correo + "\nPara: " + user.correo;

        String mensajeFinal = cabezera + mensaje;
        SistemaCorreo.generarCorreo(this.correo, user.correo, tema, mensajeFinal);
        
    }

    public Cargo getCargo(){
        return cargo;
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

    public static ArrayList<Administrador> obtenerAdmins()
    {
        ArrayList<Usuario> usuarios = Usuario.obtenerUsuarios();
        ArrayList<Administrador> admins = new ArrayList<>();

        for (Usuario usuario:usuarios){
            if (usuario instanceof Administrador){
                Administrador admin = (Administrador) usuario;
                admins.add(admin);
            }
        }

        return admins;
    }
}
