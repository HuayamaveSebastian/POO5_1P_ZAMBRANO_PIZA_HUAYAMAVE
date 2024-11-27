import com.example.Enums.*;

public class EspacioUniversidad {    //falta la extension a gestionar reserva
    private TipoEspacio tipo;
    private int CogigounicoEspacio;
    private int Capacidad;
    private String nombre;

    public EspacioUniversidad(TipoEspacio tipo, int Capacidad, String nombre) {
        this.tipo = tipo;
        this.CogigounicoEspacio = generaCodigo();
        this.Capacidad = Capacidad;
        this.nombre = nombre;
    }

    public int generarCodigo(){    //retorna un int, pero se le puso void
        return (int) (Math.random() * 10000);
    }
    
    public TipoEspacio getTipo(){
        return tipo;
    }
}
