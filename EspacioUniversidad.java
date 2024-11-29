import Enums.EstadoEspacio;
import Enums.TipoEspacio;

public class EspacioUniversidad {    //falta la extension a gestionar reserva
    private TipoEspacio tipoEspacio;
    private int cogigoUnicoEspacio;
    private int capacidad;
    private String nombre;
    private EstadoEspacio estadoEspacio;

    public EspacioUniversidad(TipoEspacio tipo, int cogigoUnicoEspacio, int capacidad, String nombre, EstadoEspacio estadoEspacio){
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.cogigoUnicoEspacio = cogigoUnicoEspacio;
        this.nombre = nombre; 
        this.estadoEspacio = estadoEspacio; 
    }

    public String getNombre (){
        return nombre;
    }

     public void setNombre(String nombre){
        this.nombre = nombre; 
    }

    public int getCapacidad (){
        return capacidad;
    }

    public void setCapacidad(int capacidad){
        this.capacidad = capacidad;
    }

    public int getCodigoUnicoEspacio(){
        return CogigounicoEspacio;
    }

    public void setCodigoUnicoEspacio(int cogigoUnicoEspacio){
        this.cogigoUnicoEspacio = cogigoUnicoEspacio;
    }

    public EstadoEspacio getEstadoEspacio(){
        return estadoEspacio;
    }

    public void setEstadoEspacio(EstadoEspacio estadoEspacio){
        this.estadoEspacio = estadoEspacio;
    }

    public TipoEspacio getTipoEspacio(){
        return tipoEspacio;
    }
    
    public void setTipo(TipoEspacio tipo){
        this.tipo = tipo; 
    }

    


    
    
}
