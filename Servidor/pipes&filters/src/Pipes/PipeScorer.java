/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pipes;

import objetosNegocio.Scorer;
import pipesandfilters.DataSink;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class PipeScorer implements Pipe<Scorer, DataSink> {

    @Override
    public void pasar(Scorer objeto) {
        DataSink sr = DataSink.getInstance();
        sr.asignarMarcador(objeto);
    }   
}
