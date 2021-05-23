/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filters;

import objetosNegocio.Tablero;
import Pipes.PipeTablero;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class FilterTablero implements Filter<Integer, Tablero, PipeTablero>{

    @Override
    public void procesar(Integer objeto) {
        //
        Tablero tablero = new Tablero(objeto);
        tablero.generaInstanciasDeFormaJuego();
        PipeTablero pt = new PipeTablero();
        pt.pasar(tablero);
    } 
}
