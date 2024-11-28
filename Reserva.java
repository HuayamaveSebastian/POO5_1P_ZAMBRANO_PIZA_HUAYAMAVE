import java.util.Date;
import Enums.*;
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

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public EspacioUniversidad getEspacio() {
        return espacio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public int getCodigoReserva() {
        return codigoReserva;
    }

    public TipoEspacio getTipo() {
        return tipo;
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
}
