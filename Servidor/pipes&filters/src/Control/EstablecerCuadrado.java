/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DataTransferObjects.DataCuadrado;
import Pipes.PipeDataCuadrado;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
class EstablecerCuadrado implements IAFPipe {

    private DataCuadrado cuadrado;

    public EstablecerCuadrado(DataCuadrado cuadrado) {
        this.cuadrado = cuadrado;
    }
    
    @Override
    public void ejecutar() {
        PipeDataCuadrado pc = new PipeDataCuadrado();
        pc.pasar(cuadrado);
    }
    
}
