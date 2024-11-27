import java.util.Date;
import com.example.*;
import com.example.Enums.*;
public class Reserva {
    private Date fechaReserva;
    private EspacioUniversidad espacio;
    private Usuario usuario;
    private int codigoReserva;
    private TipoEspacio tipo;
    private Estado estado;
    private String motivo;

    
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

    private static int contadorReservas = 0;
    
    public int generaCodigo() {
        return (int) (Math.random() * 10000); 
    }

    // Getters y Setters
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
