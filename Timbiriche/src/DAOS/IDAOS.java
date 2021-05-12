/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import objNegocio.Juego;
import objNegocio.Jugador;

/**
 *
 * @author maairiim
 */
public interface IDAOS {
    public Jugador obtener(Jugador jugador);
    public Juego obtener(Juego partida);
    public void añadirJugador(Jugador jugador);
    public void eliminarJugador(Jugador jugador);
    public void actualizarJugador(Jugador jugador);
    public void cambiarNombreJugador(Jugador jugador);
    public void cambiarColorJugador(Jugador jugador);
    public void listaJugadores();
    public void añanidrPartida();
    public void eliminarPartida();
    public void listaPartidas();
    
    
}
