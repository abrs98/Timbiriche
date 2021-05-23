/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pipes;

import DataTransferObjects.DataJugador;
import java.util.List;
import Filters.FilterJugadores;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class PipeDataJugadores implements Pipe<List<DataJugador>, FilterJugadores> {

    @Override
    public void pasar(List<DataJugador> objeto) {
        FilterJugadores fj = new FilterJugadores();
        fj.procesar(objeto);
    }
    
}
