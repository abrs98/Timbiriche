/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pipes;

import objetosNegocio.Linea;
import pipesandfilters.DataSink;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class PipeLinea implements Pipe<Linea, DataSink>{

    @Override
    public void pasar(Linea objeto) {
        DataSink sr = DataSink.getInstance();
        sr.asignarLinea(objeto);
    }
    
}
