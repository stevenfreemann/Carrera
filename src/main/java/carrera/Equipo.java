package carrera;

import java.util.Date;

/**
 * Clase que establece las variables del equipo y donde se muestra en pantalla la posición de los competidores
 *
 * @author Wilson Steven Rodriguez
 * @author Jhony Rojas
 */
public class Equipo {
    private String nombre;
    private Date termino;
    private int posicion;
    private int posicionActualP1;
    private int posicionActualP2;
    private int posicionActualP3;
    
    /**
     * Constructor de la clase Equipo
     * @param nombre variable que establece el nombre del equipo
     */
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.posicionActualP1=0;
        this.posicionActualP2=30;
        this.posicionActualP3=60;
        termino = null;
    }
    /**
     * La clase no recibe ningún parametro y es la encargada de mostrar
     * en pantalla la posición de los competidores de cada equipo.
     * 
     * @return void
     */
    public synchronized String mostrarPosicion(){
        String posicion="";
        posicion = "Pais: "+nombre+" ";
        for (int i = 0; i <= 100; i++) {
            if (i == posicionActualP1) {
                posicion += "°";
            } else if (i == posicionActualP2) {
                posicion += "^";
            } else if (i == posicionActualP3) {
                posicion += "~";
            } else {
                posicion += "_";
            }
        } 
        return posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosicionActualP1() {
        return posicionActualP1;
    }

    public void setPosicionActualP1(int posicionActualP1) {
        this.posicionActualP1 = posicionActualP1;
    }

    public int getPosicionActualP2() {
        return posicionActualP2;
    }

    public void setPosicionActualP2(int posicionActualP2) {
        this.posicionActualP2 = posicionActualP2;
    }

    public int getPosicionActualP3() {
        return posicionActualP3;
    }

    public void setPosicionActualP3(int posicionActualP3) {
        this.posicionActualP3 = posicionActualP3;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }
    
}
