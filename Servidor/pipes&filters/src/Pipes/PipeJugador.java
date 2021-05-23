/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pipes;

import objetosNegocio.Jugador;
import pipesandfilters.DataSink;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class PipeJugador implements Pipe<Jugador, DataSink> {

    @Override
    public void pasar(Jugador objeto) {
        DataSink sr = DataSink.getInstance();
        sr.retirarJugador(objeto);
        
    }
    
}
