/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pipes;

import objetosNegocio.Jugador;
import java.util.List;
import Filters.FilterScorer;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class PipeJugadores implements Pipe<List<Jugador>, FilterScorer>{

    @Override
    public void pasar(List<Jugador> objeto) {
        FilterScorer fm = new FilterScorer();
        fm.procesar(objeto);
    }
}