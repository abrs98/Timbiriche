package DataTransferObjects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Abrahan Barrios
 */
public class DataJugador implements Serializable{
    private String nombreJugador;
    private int puntaje;

    public DataJugador(String nombreJugador, int puntaje) {
        this.nombreJugador = nombreJugador;
        this.puntaje = puntaje;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nombreJugador);
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
        final DataJugador other = (DataJugador) obj;
        if (!Objects.equals(this.nombreJugador, other.nombreJugador)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JugadorDTO{" + "nombreJugador=" + nombreJugador + ", puntaje=" + puntaje + '}';
    }
}