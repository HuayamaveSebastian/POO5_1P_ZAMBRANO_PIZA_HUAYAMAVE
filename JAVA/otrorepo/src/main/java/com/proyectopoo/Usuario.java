package com.proyectopoo;

import java.sql.Date;
import java.util.ArrayList;

import com.proyectopoo.enums.Cargo;
import com.proyectopoo.enums.TipoEspacio;
import com.proyectopoo.enums.TipoUsuario;
import com.proyectopoo.utilidades.ManejoArchivos;

public abstract class Usuario {
    protected String nombre;
    protected String apellido;
    protected String numCedula;   //Considero que es String por el hecho de que son numeros excesivos comenzando desde el 0.
    protected String codigoUnico;
    protected String usuario;
    protected String contrasenia;
    protected String correo; 
    protected TipoUsuario tipo;

    public Usuario(String nombre, String apellido, String codigoUnico, String numCedula, String usuario, String contrasenia, String correo)
    {
        this.apellido = apellido;
        this.codigoUnico = codigoUnico;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.nombre = nombre;
        this.numCedula = numCedula;
        this.usuario = usuario;
    }

    public Reserva hacerReserva(Date fecha, EspacioUniversidad espacio, String motivo)
    {
        // (String codigoUsuario, String cedula, Date fechaReserva, int codigoEspacio, TipoEspacio tipo, String motivo) 
        Reserva reserva = new Reserva(this.codigoUnico , this.numCedula, fecha, espacio.getCodigoUnicoEspacio(), espacio.getTipo(), motivo);

        Reserva.reservas.add(reserva);

        // "5001 | 002 | 0912345678 | 2024-10-10 | 103 | LABORATORIO | APROBADO | Fundamentos de Programación"
        String linea = reserva.getCodigoReserva() + " | " + reserva.getCodigoUsuario() + " | " + reserva.getCedula() + " | " + fecha + " | " +  reserva.getCodigoEspacio() + " | " + reserva.getTipo() + " | " + reserva.getEstado() + " | " + reserva.getMotivo(); 
        ManejoArchivos.EscribirArchivo("reservas.txt", linea);
        System.out.println("Reserva GENERADA!!!");

        return reserva;
    }
/*
    public String toString() {
        return "Usuario{" +
               "nombre='" + nombre + '\'' +       
               ", apellido='" + apellido + '\'' +
               ", numCedula=" + numCedula +
               ", correo='" + correo + '\'' +
               '}';
    }
*/
    protected void enviarCorreo(String correoprofesor, TipoEspacio tipo,String materia )
    {
        System.out.println("Solicitud en proceso, se enviará un correo a profesor:" + correoprofesor);
        System.out.println("Tipo de espacio: " + tipo + ", Materia: " + materia);
    }

    protected void enviarCorreo(String destinatario, String cuerpo) {
        System.out.println("De: " + this.correo);
        System.out.println("Para: " + destinatario);
        System.out.println("Asunto: Reserva Realizada");
        System.out.println("Mensaje: " + cuerpo);
    }
    
    public void setNombres(String nombre){
        this.nombre = nombre;
    }

    public String getNombres(){
        return nombre;
    }

    public void setApellidos(String apellido){
        this.apellido = apellido;
    }

    public String getApellido(){
        return apellido;

    }
    public String getNumCedula(){
        return numCedula;
    }

    public void setNumCedula(String numCedula){
        this.numCedula = numCedula;
    }

    public String getCodigoUnico(){
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico){
        this.codigoUnico = codigoUnico;
    }

    public String getUsuario(){
        return usuario;
    }

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public String getContrasenia(){
        return contrasenia;
    }

    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public static ArrayList<Usuario> obtenerUsuarios()
    {
        ArrayList<Usuario> usuarios = new ArrayList<>();
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

            switch(tipo.charAt(0))
            {
                case 'E':
                    
                    ArrayList<String> linease = ManejoArchivos.LeeFichero("estudiantes.txt");

                    for (String datoe:linease)
                    {
                        String[] lineaDatoe = datoe.split("\\|");
                        String codigoe = lineaDatoe[0].trim();
                        String cedulae = lineaDatoe[1].trim();
                        String matricula = lineaDatoe[4].trim();
                        String carrerae = lineaDatoe[5].trim();

                        if (cedula.equals(cedulae)  && codigo.equals(codigoe))   
                            usuarios.add(new Estudiante(nombre, apellido,codigoe, cedulae, userDato, contraseniaDato, email, matricula, carrerae));
                        
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
                        
                        if (cedula.equals(cedulap)  && codigo.equals(codigop))  
                            usuarios.add(new Profesor(nombre, apellido,codigop, cedulap, userDato, contraseniaDato, email, materias, facultad));
                        
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



                        if (cedula.equals(cedulaa)  && codigo.equals(codigoa)){

                            usuarios.add(new Administrador(nombre, apellido, codigoa,cedulaa, userDato, contraseniaDato, email,enumCargo));
                        }  
                            

                        
                    }

                    break;
                            
            }

           
            

        }


        return usuarios;
    }

    public static Usuario obtenerUsuarioPorCodigo(String codigo)
    {
        ArrayList<Usuario> usuarios = obtenerUsuarios();

        for (Usuario usuario:usuarios){
            if (usuario.getCodigoUnico().equals(codigo))
                return usuario;
        }

        return null;
    }
}        
        
        

        




    


