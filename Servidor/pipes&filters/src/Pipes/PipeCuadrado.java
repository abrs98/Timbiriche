/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pipes;

import objetosNegocio.Cuadro;
import pipesandfilters.DataSink;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class PipeCuadrado implements Pipe<Cuadro, DataSink> {

    @Override
    public void pasar(Cuadro objeto) {
        DataSink sr = DataSink.getInstance();
        sr.asignarCuadro(objeto);
    }   
}