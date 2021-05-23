/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DataTransferObjects.DataLinea;
import Pipes.PipeDataLinea;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
class EstablecerLinea implements IAFPipe{
    
    private DataLinea linea;

    public EstablecerLinea(DataLinea linea) {
        this.linea = linea;
    }

    @Override
    public void ejecutar() {
        PipeDataLinea pl = new PipeDataLinea();
        pl.pasar(linea);
    }    
}