/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filters;

import objetosNegocio.Jugador;
import objetosNegocio.Linea;
import objetosNegocio.Coordenada;
import DataTransferObjects.DataLinea;
import Pipes.PipeLinea;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class FilterLinea implements Filter<DataLinea, Linea, PipeLinea>{

    @Override
    public void procesar(DataLinea objeto) {
        Jugador jugador = new Jugador(objeto.getJugador().getNombreJugador());
        Linea linea = new Linea(Coordenada.valueOf(objeto.getPosicion()), jugador, objeto.getIndice());
        PipeLinea pl = new PipeLinea();
        pl.pasar(linea);
    }
}
