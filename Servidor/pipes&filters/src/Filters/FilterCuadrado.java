/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filters;

import objetosNegocio.Cuadro;
import objetosNegocio.Jugador;
import DataTransferObjects.DataCuadrado;
import Pipes.PipeCuadrado;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class FilterCuadrado implements Filter<DataCuadrado, Cuadro, PipeCuadrado>{

    @Override
    public void procesar(DataCuadrado objeto) {
        Jugador jugador = new Jugador(objeto.getJugador().getNombreJugador());
        
        Cuadro cuadro = new Cuadro(jugador, objeto.getIndice());
        PipeCuadrado pc = new PipeCuadrado();
        pc.pasar(cuadro);
    } 
}
