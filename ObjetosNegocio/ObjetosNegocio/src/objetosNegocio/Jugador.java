/**
 * Jugador.java
 */
package objetosNegocio;

import java.awt.Color;
import java.util.Objects;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class Jugador {
    private String nombre;
    private int puntaje;
    private Color color;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public Jugador(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public java.awt.Color getColor() {
        return color;
    }

    public void setColor(java.awt.Color color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        int hash = 4;
        hash = 20 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jugador other = (Jugador) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
}