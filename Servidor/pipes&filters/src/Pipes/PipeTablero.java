/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pipes;

import objetosNegocio.Tablero;
import pipesandfilters.DataSink;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class PipeTablero implements Pipe<Tablero, DataSink>{

    @Override
    public void pasar(Tablero objeto) {
        DataSink sr = DataSink.getInstance();
        sr.asignarTablero(objeto);
    }
    
}
