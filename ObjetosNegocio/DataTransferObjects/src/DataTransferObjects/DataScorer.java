package DataTransferObjects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Abrahan Barrios
 */
public class DataScorer implements Serializable{
    private List<DataJugador> jugadores;
    private int siguiente;

    public DataScorer(List<DataJugador> jugadores) {
        this.jugadores = jugadores;
        this.siguiente = 0;
    }

    public DataScorer(List<DataJugador> jugadores, int siguiente) {
        this.jugadores = jugadores;
        this.siguiente = siguiente;
    }

    public List<DataJugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<DataJugador> jugadores) {
        this.jugadores = jugadores;
    }

    public int getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(int siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "MarcadorDTO{" + "jugadores=" + jugadores + ", siguiente=" + siguiente + '}';
    }
}