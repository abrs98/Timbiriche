/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pipes;

import DataTransferObjects.DataLinea;
import Filters.FilterLinea;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class PipeDataLinea implements Pipe<DataLinea, FilterLinea>{

    @Override
    public void pasar(DataLinea objeto) {
        FilterLinea fl = new FilterLinea();
        fl.procesar(objeto);
    }   
}