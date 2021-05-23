/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import DataTransferObjects.DataCuadrado;
import DataTransferObjects.DataJugador;
import DataTransferObjects.DataLinea;
import java.util.List;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public interface IAF {
    void crearSala(List<DataJugador> jugadores);
    void asignarLinea(DataLinea linea);
    void asignarCuadro(DataCuadrado cuadro);
    void retirarJugador(DataJugador jugador);
}