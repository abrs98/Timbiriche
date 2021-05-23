/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filters;

import objetosNegocio.Jugador;
import objetosNegocio.Scorer;
import java.util.List;
import Pipes.PipeScorer;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class FilterScorer implements Filter<List<Jugador>, Scorer, PipeScorer>{

    @Override
    public void procesar(List<Jugador> objeto) {
        Scorer marcador = new Scorer(objeto);
        PipeScorer pm = new PipeScorer();
        pm.pasar(marcador);
    }   
}