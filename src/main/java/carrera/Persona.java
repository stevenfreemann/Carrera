package carrera;

import Logica.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que establece las variables de las personas que compiten
 *
 * @author Wilson Steven Rodriguez
 * @author Jhony rojas
 */
public class Persona extends Thread{
    Equipo equipo;
    private String nombre;
    private int posisionInicial;
    private int posicionFinal;
    private String col;
    private String ven;
    private String ecu;
    /**
     * Constructor de la clase que establece los siguientes parametros:
     * @param nombre variable de tipo String que captura el nombre del competidor
     * @param posisionInicial variable de tipo entero que captura la posicion inicial del competidor
     * @param posicionFinal variable de tipo entero que captura la posicion final del competidor
     * @param equipo objeto de la clase Equipo que captura a que equipo pertenece cada competidor
     */
    public Persona(String nombre, int posisionInicial, int posicionFinal, Equipo equipo) {
        this.nombre = nombre;
        this.posisionInicial = posisionInicial;
        this.posicionFinal = posicionFinal;
        this.equipo = equipo;
    }

    Persona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void run(){
        if (posisionInicial == 0) {
            cicloPersonaUno();
        } else {
            sincronizadoEspera();
        }
        if (posisionInicial == 30) {
            cicloPersonaDos();
        } else {
            sincronizadoEspera();
        }
        if (posisionInicial == 60) {
            cicloPersonaTres();
        } else {
            sincronizadoEspera();
        }
    }
    
    /**
     * Metodo que realiza el ciclo del competidor 1 de cada equipo
     */
    public void cicloPersonaUno(){
        while (true) {
            int pasoActual = avanzar(1);
            if (pasoActual >= 30) {
                equipo.setPosicionActualP1(30);
                synchronized (equipo) {
                    equipo.notifyAll();
                    posisionInicial = 30;
                }
                break;
            }
        }
    }
    
    /**
     * Metodo que realiza el ciclo del competidor 2 de cada equipo
     */
    public void cicloPersonaDos(){
        while (true) {
            int pasoActual = avanzar(2);
            if (pasoActual >= 60) {
                equipo.setPosicionActualP2(60);
                synchronized (equipo) {
                    equipo.notify();
                }
                break;
            }
        }
    }
    
    /**
     * Metodo que realiza el ciclo del competidor 3 de cada equipo y da por finalizada la carrera
     */
    public  void cicloPersonaTres(){
        while (true) {
            int pasoActual = avanzar(3);
            if (pasoActual >= 100) {
                equipo.setPosicionActualP3(100);
                if(equipo.getNombre().equals("COL")){
                    equipo.setNombre("COLOMBIA");
                }else if(equipo.getNombre().equals("VEN")){
                    equipo.setNombre("VENEZUELA");
                }else if(equipo.getNombre().equals("ECU")){
                    equipo.setNombre("ECUADOR");
                }
                System.out.println(equipo.getNombre()+" Llegó a la meta primero");
                Principal p = new Principal();
                
                break;
            }
        }
        System.exit(0);
    }
    
    /**
     * Metodo que se encarg de hacer esperar los hilos
     */
    public void sincronizadoEspera(){
        synchronized (equipo) {
            try {
                equipo.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Metodo que sirve para hacer que cada competidor avance y recibe como parametro el numero del atleta
     * @param numAtleta variable de tipo entero que establece el numero del competidor
     * @return int
     */
    public int avanzar(int numAtleta) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        int avance = Utilitaria.random();
        if (numAtleta == 1) {
            equipo.setPosicionActualP1(equipo.getPosicionActualP1()+ avance);
            equipoPerteneciente();
            return equipo.getPosicionActualP1();
        }
        if (numAtleta == 2) {
            equipo.setPosicionActualP2(equipo.getPosicionActualP2() + avance);
            equipoPerteneciente();
            return equipo.getPosicionActualP2();
        }
        if (numAtleta == 3) {
            equipo.setPosicionActualP3(equipo.getPosicionActualP3()+ avance);
            equipoPerteneciente();
            return equipo.getPosicionActualP3();
        }
        return 0;
    }
    
    /**
     * Metodo que no recibe ningún parametro y se encarga de validar a que
     * equipo pertenece el jugador
     */
    public void equipoPerteneciente(){
        if(equipo.mostrarPosicion().contains("COL")){
            col=equipo.mostrarPosicion();
            if(col!=null){
                System.out.println(col);
            }
        }else if(equipo.mostrarPosicion().contains("VEN")){
            ven=equipo.mostrarPosicion();
            if(ven!=null){
                System.out.println(ven);
            }
        }else if(equipo.mostrarPosicion().contains("ECU")){
            ecu=equipo.mostrarPosicion();
            if(ecu!=null){
                System.out.println(ecu);
            }
        }
    }
}
