package DataTransferObjects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;

/**
 *
 * @author Abrahan Barrios
 */
public enum DataMensaje implements Serializable {
    VOTO, CREAR_SALA, EMPEZAR_PARTIDA, JUGADOR_NUEVO, TURNO_TERMINADO, MARCADOR
}
