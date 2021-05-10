/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objNegocio;

/**
 *
 * @author maairiim
 */
public class Jugador {
    private int idJugador;
    private String nombre;
    private String color;

    public Jugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public Jugador(int idJugador, String nombre, String color) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.color = color;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
    
}
