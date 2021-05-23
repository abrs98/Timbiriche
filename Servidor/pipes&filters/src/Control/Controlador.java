/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DataTransferObjects.DataCuadrado;
import DataTransferObjects.DataJugador;
import DataTransferObjects.DataLinea;
import java.util.List;
import pipesandfilters.IAF;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class Controlador implements IAF{
    
    IAFPipe comando;

    @Override
    public void crearSala(List<DataJugador> jugadores) {
        comando = new EmpezarPartida(jugadores);
        comando.ejecutar();
    }

    @Override
    public void asignarLinea(DataLinea linea) {
        comando = new EstablecerLinea(linea);
        comando.ejecutar();
    }

    @Override
    public void asignarCuadro(DataCuadrado cuadro) {
        comando = new EstablecerCuadrado(cuadro);
        comando.ejecutar();
    }

    @Override
    public void retirarJugador(DataJugador jugador) {
        comando = new CambiarTurno(jugador);
        comando.ejecutar();
    }   
}