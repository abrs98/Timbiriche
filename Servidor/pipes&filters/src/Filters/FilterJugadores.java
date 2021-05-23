/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filters;

import objetosNegocio.Jugador;
import DataTransferObjects.DataJugador;
import java.util.ArrayList;
import java.util.List;
import Pipes.PipeJugadores;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class FilterJugadores implements Filter<List<DataJugador>, List<Jugador>, PipeJugadores>{

    @Override
    public void procesar(List<DataJugador> objeto) {
        List<Jugador> jugadores = new ArrayList<>();
        for (DataJugador jugadorDTO : objeto) {
            Jugador jugador = new Jugador(jugadorDTO.getNombreJugador());
            jugadores.add(jugador);
        }
        PipeJugadores pj = new PipeJugadores();
        pj.pasar(jugadores);
    }
}