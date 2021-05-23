package DataTransferObjects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Abrahan Barrios
 */
public class Movimiento implements Serializable{

    private DataLinea linea;
    private List<DataCuadrado> cuadros = new ArrayList<>();

    public DataLinea getLinea() {
        return linea;
    }

    public void setLinea(DataLinea linea) {
        this.linea = linea;
    }

    public List<DataCuadrado> getCuadros() {
        return cuadros;
    }

    public void setCuadros(List<DataCuadrado> cuadros) {
        this.cuadros = cuadros;
    }

    public void setCuadro(DataCuadrado cuadro) {
        if(cuadros.size() < 2){
            cuadros.add(cuadro);
        }else{
            cuadros.remove(0);
            cuadros.add(cuadro);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.linea);
        hash = 37 * hash + Objects.hashCode(this.cuadros);
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
        final Movimiento other = (Movimiento) obj;
        if (!Objects.equals(this.linea, other.linea)) {
            return false;
        }
        if (!Objects.equals(this.cuadros, other.cuadros)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MovimientoDTO{" + "linea=" + linea + ", cuadros=" + cuadros + '}';
    }
}