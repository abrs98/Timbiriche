/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DataTransferObjects.DataJugador;
import java.util.List;
import Pipes.PipeDataJugadores;
import Pipes.PipeTamanio;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
class EmpezarPartida implements IAFPipe{

    private List<DataJugador> jugadores;

    public EmpezarPartida(List<DataJugador> jugadores) {
        this.jugadores = jugadores;
    }
    
    @Override
    public void ejecutar() {
        PipeDataJugadores pj = new PipeDataJugadores();
        pj.pasar(jugadores);
        PipeTamanio pt = new PipeTamanio();
        pt.pasar(jugadores.size());
    }
    
}
