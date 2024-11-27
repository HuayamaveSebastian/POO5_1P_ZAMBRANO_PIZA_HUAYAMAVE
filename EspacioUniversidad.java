import com.example.Enums.*;

public class EspacioUniversidad {    //falta la extension a gestionar reserva
    private TipoEspacio tipo;
    private int CogigounicoEspacio;
    private int Capacidad;
    private String nombre;
    private EstadoEspacio estadoEspacio;

    public EspacioUniversidad(TipoEspacio tipo, int CogigounicoEspacio, int Capacidad, String nombre, EstadoEspacio estadoEspacio){
        this.Capacidad = Capacidad;
        this.tipo = tipo;
        this.CogigounicoEspacio = CogigounicoEspacio;
        this.nombre = nombre; 
        this.estadoEspacio = estadoEspacio; 
    }

    public void setTipo(TipoEspacio tipo){
        this.tipo = tipo; 
    }

    public TipoEspacio getTipo(){
        return tipo;
    }

    public void setCodigoUnicoEspacio(int CogigounicoEspacio){
        this.CogigounicoEspacio = CogigounicoEspacio;
    }

    public int getCodigoUnicoEspacio(){
        return CogigounicoEspacio;
    }

    public void setCapacidad(int Capacidad){
        this.Capacidad = Capacidad;
    }

    public int getCapacidad (){
        return Capacidad;
    }

    public void setNombre(String nombre){
        this.nombre = nombre; 
    }

    public String getNombre (){
        return nombre;
    }

    public void setEstadoEspacio(EstadoEspacio estadoEspacio){
        this.estadoEspacio = estadoEspacio;
    }

    public EstadoEspacio getEstadoEspacio(){
        return estadoEspacio;
    }
    
}
