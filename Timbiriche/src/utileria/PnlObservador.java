/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utileria;

import objetosNegocio.FormaJuego;
import java.util.List;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public interface PnlObservador {
    void actualiza(List<FormaJuego> movimiento);
}