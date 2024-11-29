package com.proyectopoo;
import java.util.ArrayList;

import com.proyectopoo.enums.EspacioPermiso;
import com.proyectopoo.enums.EstadoEspacio;
import com.proyectopoo.enums.TipoEspacio;
import com.proyectopoo.utilidades.ManejoArchivos;

public class EspacioUniversidad {    
    private TipoEspacio tipo;
    private int CodigounicoEspacio;
    private int Capacidad;
    private String nombre;
    private EstadoEspacio estadoEspacio;
    private EspacioPermiso permiso;

    public static ArrayList<EspacioUniversidad> espacios = null;
    

    public EspacioUniversidad(TipoEspacio tipo, int CodigounicoEspacio, int Capacidad, String nombre, EstadoEspacio estadoEspacio, EspacioPermiso permiso)
    {
        this.Capacidad = Capacidad;
        this.tipo = tipo;
        this.CodigounicoEspacio = CodigounicoEspacio;
        this.nombre = nombre; 
        this.estadoEspacio = estadoEspacio; 
        this.permiso = permiso;
    }

    public void setTipo(TipoEspacio tipo){
        this.tipo = tipo; 
    }

    public TipoEspacio getTipo(){
        return tipo;
    }

    public void setCodigoUnicoEspacio(int CogigounicoEspacio){
        this.CodigounicoEspacio = CogigounicoEspacio;
    }

    public int getCodigoUnicoEspacio(){
        return CodigounicoEspacio;
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

    public String toString()
    {
        return "Espacio: " + nombre + " | Capacidad: " + Capacidad + " | Codigo Unico: " + CodigounicoEspacio;
    }

    public static ArrayList<EspacioUniversidad> obtenerEspacios(){
        ArrayList<EspacioUniversidad> espacios = new ArrayList<>();

        ArrayList<String> lineas = ManejoArchivos.LeeFichero("espacios.txt");
        for (String linea:lineas)
        {
            String[] lineaDato = linea.split("\\|");
            int codigoEspacio = Integer.valueOf(lineaDato[0].trim());
            TipoEspacio tipoEspacio = TipoEspacio.valueOf(lineaDato[1].trim());
            String nombre = lineaDato[2].trim();
            int capacidad = Integer.valueOf(lineaDato[3].trim());
            EstadoEspacio estado = EstadoEspacio.valueOf(lineaDato[4].trim());
            EspacioPermiso permiso = EspacioPermiso.valueOf(lineaDato[5].trim());

           

            espacios.add(new EspacioUniversidad(tipoEspacio,codigoEspacio,capacidad,nombre,estado,permiso));
            
        }

        return espacios;
    }

    public static EspacioUniversidad buscarEspacio(int codigo)
    {
        ArrayList<EspacioUniversidad> espacios = obtenerEspacios();

        for (EspacioUniversidad espacio:espacios){
            if (espacio.CodigounicoEspacio == codigo)
                return espacio;
        }
        return null;
    }


    public static ArrayList<EspacioUniversidad> buscarEspacios(EspacioPermiso permiso, TipoEspacio tipo)
    {
        ArrayList<EspacioUniversidad> espacios = (ArrayList<EspacioUniversidad>) EspacioUniversidad.espacios.clone();

        espacios.removeIf((espacio-> espacio.estadoEspacio != EstadoEspacio.DISPONIBLE || espacio.tipo != tipo || (espacio.permiso != permiso && espacio.permiso != EspacioPermiso.AMBOS)));

        return espacios;
    }
}
