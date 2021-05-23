/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pipes;

import DataTransferObjects.DataJugador;
import Filters.FilterJugador;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class PipeDataJugador implements Pipe<DataJugador, FilterJugador>{

    @Override
    public void pasar(DataJugador objeto) {
        FilterJugador fj = new FilterJugador();
        fj.procesar(objeto);
    }   
}