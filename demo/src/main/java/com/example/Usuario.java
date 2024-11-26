package com.example;

abstract class Usuario {
    protected String nombre;
    protected String apellido;
    protected int numCedula;
    protected int codigoUnico;
    protected String usuario;
    protected String contrasenia;
    protected String correo; 

    public Usuario(String nombre, String apellido, int numCedula, String usuario, String contrasenia, String correo){
        this.apellido = apellido;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.nombre = nombre;
        this.numCedula = numCedula;
        this.usuario = usuario;
    }
    protected void consultarReserva(String fecha){

    }

    public abstract void gestionarReserva (String fecha);

    

    protected void enviarCorreo(String profesor,Enum tipoEspacio,String materia ){
        System.out.println("Solicitud en proceso, se enviará un correo a profesor:" + profesor.getCorreo());

    }

    protected void enviarCorreo(String estudiante,Enum tipoEspacio, int matricula){
        System.out.println("Enviando correo a estudiante:" + estudiante.getCorreo());

    }

    public String getNombres(){
        return nombres;
    }
    
    public void setNombres(String nombres){
        this.nombres = nombres;
    }

    public String getApellido(){
        return apellidos;
    }

    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public int getNumCedula(){
        return numCedula;
    }

    public void setNumCedula(int numCedula){
        this.numCedula = numCedula;
    }

    public getCodigoUnico(){
        return codigoUnico;
    }

    public void setCodigoUnico(int codigoUnico){
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
        this.contraenia = contrasenia;
    }

    public String getCOrreo(){
        return correo;
    }

    public setCorreo(String correo){
        this.correo = correo;
    }

        
        
        




    
}

