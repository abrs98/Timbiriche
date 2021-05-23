/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import objetosNegocio.Cuadro;
import objetosNegocio.Jugador;
import objetosNegocio.Linea;
import objetosNegocio.Scorer;
import DataTransferObjects.DataCuadrado;
import DataTransferObjects.DataJugador;
import DataTransferObjects.DataLinea;
import DataTransferObjects.DataScorer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class AccessData implements IData {

    private DataSink sr = DataSink.getInstance();

    @Override
    public DataScorer obtenerMarcador() {
        Scorer scorer = sr.obtenerMarcador();

        List<DataJugador> dataJugadores = new ArrayList<>();
        for (Jugador jugador : scorer.getJugadores()) {
            dataJugadores.add(new DataJugador(jugador.getNombre(), jugador.getPuntaje()));
        }
        DataScorer marcadorDTO = new DataScorer(dataJugadores);

        return marcadorDTO;
    }

    @Override
    public DataLinea obtenerUltimaLinea() {
        Linea linea = sr.obtenerUltimaLinea();
        if (linea != null) {
            DataLinea lineaDTO
                    = new DataLinea(
                            linea.getPosicion().toString(),
                            linea.getIndice(),
                            new DataJugador(
                                    linea.getJugador().getNombre(),
                                    linea.getJugador().getPuntaje()));
            return lineaDTO;
        }else{
            return null;
        }
    }

    @Override
    public DataCuadrado obtenerUltimoCuadro() {
        Cuadro cuadro = sr.obtenerUltimoCuadro();
        DataCuadrado dataCuadrado
                = new DataCuadrado(cuadro.getIndice(),
                        new DataJugador(cuadro.getJugador().getNombre(),
                                cuadro.getJugador().getPuntaje()));

        return dataCuadrado;
    }

    @Override
    public int obtenerTurnoSiguiente() {
        return sr.obtenerTurnoSiguiente();
    }
}
