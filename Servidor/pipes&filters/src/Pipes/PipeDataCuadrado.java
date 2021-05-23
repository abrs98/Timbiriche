/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pipes;

import DataTransferObjects.DataCuadrado;
import Filters.FilterCuadrado;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class PipeDataCuadrado implements Pipe<DataCuadrado, FilterCuadrado>{

    @Override
    public void pasar(DataCuadrado objeto) {
        FilterCuadrado fc = new FilterCuadrado();
        fc.procesar(objeto);
    }
    
}
