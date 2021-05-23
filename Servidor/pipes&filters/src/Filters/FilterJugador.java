/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filters;

import objetosNegocio.Jugador;
import DataTransferObjects.DataJugador;
import Pipes.PipeJugador;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class FilterJugador implements Filter<DataJugador, Jugador, PipeJugador> {

    @Override
    public void procesar(DataJugador objeto) {
        Jugador jugador = new Jugador(objeto.getNombreJugador());
        PipeJugador pj = new PipeJugador();
        pj.pasar(jugador);
    }
}
