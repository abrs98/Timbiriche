/**
 * Sala.java
 * 10 de Mayo 2021, 02:13pm.
 */
package objetosNegocio;

import java.util.List;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class Juego {
    
    private Tablero tablero;
    private Scorer marcador;
    private int tamanio;

    public Juego() {}

    /**
     * Constructor de Sala
     * @param marcador
     * @param tablero
     * @param tamanio 
     */
    public Juego(Scorer marcador, Tablero tablero, int tamanio) {
        this.tablero = tablero;
        this.marcador = marcador;
        this.tamanio = tamanio;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Scorer getMarcador() {
        return marcador;
    }

    public void setMarcador(Scorer marcador) {
        this.marcador = marcador;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
    
    public void agregarJugador(Jugador jugador){
        if(this.marcador.getJugadores().size() < this.tamanio){
            this.marcador.getJugadores().add(jugador);
        }
    }
    
    public void eliminarJugador(Jugador jugador){
        this.marcador.getJugadores().remove(jugador);
    }
}