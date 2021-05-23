/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import DataTransferObjects.DataCuadrado;
import DataTransferObjects.DataLinea;
import DataTransferObjects.DataScorer;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public interface IData {
    DataScorer obtenerMarcador();
    DataLinea obtenerUltimaLinea();
    DataCuadrado obtenerUltimoCuadro();
    int obtenerTurnoSiguiente();
}
