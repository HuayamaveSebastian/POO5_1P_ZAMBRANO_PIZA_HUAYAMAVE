import java.util.Date;
import Enums.*;
import java.io.*;

public class Reserva {
    private Date fechaReserva; 
    private EspacioUniversidad espacio;
    private Usuario usuario; 
    private int codigoReserva;
    private TipoEspacio tipo; 
    private Estado estado; 
    private String motivo;
    private static int contadorReservas = 0;
    
    public Reserva(Date fechaReserva, EspacioUniversidad espacio, Usuario usuario, TipoEspacio tipo, String motivo) {
        this.fechaReserva = fechaReserva;
        this.espacio = espacio;
        this.usuario = usuario;
        this.codigoReserva = generaCodigo();
        this.tipo = tipo;
        this.estado = Estado.Pendiente; 
        this.motivo = motivo;
        contadorReservas++;
    }

    private int generarCoidigo(){
        return contadorReservas + 5000;  
    }

    public Date getFechaReserva() {
        return fechaReserva;           
    }

    public void setFechaReserva(Date fechaReserva){
        this.fechaReserva = fechaReserva; 
    }

    public EspacioUniversidad getEspacio() {
        return espacio;  
    }
    
    public void setEspacio(EspacioUniversidad espacio) {
        return espacio = espacio; 
    

    public Usuario getUsuario() {
        return usuario;
    }
        
    public void setUsuario(Uusario usuario) {
        this.usuario = usuario;
        

    public int getCodigoReserva() {
        return codigoReserva;
    }

    public TipoEspacio getTipo() {
        return tipo;
    }
        
    public void setTipo(TipoEspacio tipo) {
        this.tipo = tipo;
    }
        

    public Estado getEstado() {
        return estado;
    }
        
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }
    
    public void setMotivo(String motivo) {
        this.motivo =motivo;
    }

    @Override
    public String toString(){
        return "Reseva{" +
            "fechaReserva="+ fechaReserva + ", espacio=" + espacio + ", usuario=" + usuario + ", codigoReserva="  + codigoReserva +
            ",tipo=" + tipo + ", motivo=" + '\'' + '}';

    
}
