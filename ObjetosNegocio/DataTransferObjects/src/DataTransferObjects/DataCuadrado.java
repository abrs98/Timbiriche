package DataTransferObjects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;

/**
 *
 * @author Abrahan Barrios
 */
public class DataCuadrado implements Serializable{

    private int indice;
    private DataJugador jugador;

    public DataCuadrado(int indice, DataJugador jugador) {
        this.indice = indice;
        this.jugador = jugador;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public DataJugador getJugador() {
        return jugador;
    }

    public void setJugador(DataJugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.indice;
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
        final DataCuadrado other = (DataCuadrado) obj;
        if (this.indice != other.indice) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CuadroDTO{" + indice + ", " + jugador + ")";
    }
}