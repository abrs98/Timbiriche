/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import DataTransferObjects.DataCuadrado;
import DataTransferObjects.DataJugador;
import DataTransferObjects.DataLinea;
import DataTransferObjects.DataMensaje;
import DataTransferObjects.Movimiento;
import DataTransferObjects.DataResponse;
import java.util.List;
import pipesandfilters.AccessData;
import Control.Controlador;
import pipesandfilters.IData;
import pipesandfilters.IAF;

/**
 *
 * @author  Abrahan Barrios, Victor Torres, Ana Rios
 */
public class SckServerProtocol {

    private IAF ipaf;
    private IData repo;

    public SckServerProtocol() {
        this.ipaf = new Controlador();
        this.repo = new AccessData();
    }

    public Object procesarEntrada(Object mensajeEntrante) {

        //Si despues de realizada la conexion, el socket del cliente manda los
        //datos del jugador, le avisa al Thread que efectivamente son los datos
        if (mensajeEntrante instanceof DataJugador) {
            return DataMensaje.JUGADOR_NUEVO;

            //Si se reciben los datos de un Movimiento, se manda al componente 
            //PipesAndFilters para realizar la conversion correspondiente, asignar 
            //y obtener respuesta
        } else if (mensajeEntrante instanceof Movimiento) {
            Movimiento movimiento = (Movimiento) mensajeEntrante;
            
            if(movimiento.getLinea() != null){
                ipaf.asignarLinea(movimiento.getLinea());
            }else if(movimiento.getCuadros() != null){
                for (DataCuadrado cuadro : movimiento.getCuadros()) {
                    ipaf.asignarCuadro(cuadro);
                }
            }
            
            DataResponse respuesta = new DataResponse(movimiento, repo.obtenerMarcador());
            return respuesta;
            
            //Si un cliente vota, se verifica y se manda respuesta
        } else if (mensajeEntrante == DataMensaje.VOTO) {
            return DataMensaje.VOTO;
        } else if (mensajeEntrante == DataMensaje.TURNO_TERMINADO) {
            return repo.obtenerTurnoSiguiente();
        } else if (mensajeEntrante == DataMensaje.MARCADOR) {
            return repo.obtenerMarcador();
        }

        return null;
    }

    public Object empezarPartida(List<DataJugador> dataJugadores) {
        ipaf.crearSala(dataJugadores);
        return repo.obtenerMarcador();
    }
}
