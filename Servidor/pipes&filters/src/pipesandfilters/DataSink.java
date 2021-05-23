/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import objetosNegocio.*;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class DataSink {

    private volatile static DataSink instance;
    private volatile Juego sala;
    private volatile Linea ultimaLinea;
    private volatile Cuadro ultimoCuadro;

    private DataSink() {
        sala = new Juego();
    }

    public static synchronized DataSink getInstance() {
        if (instance == null) {
            instance = new DataSink();
        }
        return instance;
    }

    public synchronized void asignarMarcador(Scorer marcador) {
        this.sala.setMarcador(marcador);
    }

    public synchronized void asignarTablero(Tablero tablero) {
        this.sala.setTablero(tablero);
    }

    public synchronized void asignarLinea(Linea linea) {
        if(linea.getPosicion() == Coordenada.HORIZONTAL){
            this.sala.getTablero().getLineasHorizontales().get(linea.getIndice()).setJugador(linea.getJugador());
            this.ultimaLinea = this.sala.getTablero().getLineasHorizontales().get(linea.getIndice());
        }else if(linea.getPosicion() == Coordenada.VERTICAL){
            this.sala.getTablero().getLineasVerticales().get(linea.getIndice()).setJugador(linea.getJugador());
            this.ultimaLinea = this.sala.getTablero().getLineasVerticales().get(linea.getIndice());
        }
    }

    public synchronized void asignarCuadro(Cuadro cuadro) {
        for (Jugador jugador : this.sala.getMarcador().getJugadores()) {
            if(jugador.equals(cuadro.getJugador())){
                this.sala.getTablero().getCuadros().get(cuadro.getIndice()).setJugador(jugador);
                jugador.setPuntaje(jugador.getPuntaje()+1);
                this.ultimoCuadro = this.sala.getTablero().getCuadros().get(cuadro.getIndice());
            }
        }
    }

    public synchronized void retirarJugador(Jugador jugador) {
        for (Jugador jugObj : this.sala.getMarcador().getJugadores()) {
            if(jugObj.equals(jugador)){
                this.sala.getMarcador().getJugadores().remove(jugObj);
                
                for (Linea vertical : this.sala.getTablero().getLineasVerticales()) {
                    if(vertical.getJugador().equals(jugObj)){
                        vertical.setJugador(null);
                    }
                }
                
                for (Linea horizontal : this.sala.getTablero().getLineasHorizontales()) {
                    if(horizontal.getJugador().equals(jugObj)){
                        horizontal.setJugador(null);
                    }
                }
                
                for (Cuadro cuadro : this.sala.getTablero().getCuadros()) {
                    if(cuadro.getJugador().equals(jugObj)){
                        cuadro.setJugador(null);
                    }
                }
            }
        }
    }

    public synchronized Juego getSala() {
        return sala;
    }
    
    public synchronized Scorer obtenerMarcador(){
        return this.sala.getMarcador();
    }
    
    public synchronized Linea obtenerUltimaLinea(){
        return this.ultimaLinea;
    }
    
    public synchronized Cuadro obtenerUltimoCuadro(){
        return this.ultimoCuadro;
    }
    
    public synchronized int obtenerTurnoSiguiente(){
        return this.sala.getMarcador().getSiguiente();
    }
}