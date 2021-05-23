/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DataTransferObjects.DataJugador;
import Pipes.PipeDataJugador;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
class CambiarTurno implements IAFPipe {
    
    private DataJugador jugador;

    public CambiarTurno(DataJugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void ejecutar() {
        PipeDataJugador pj = new PipeDataJugador();
        pj.pasar(jugador);
    }
    
}
