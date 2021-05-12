/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import java.util.ArrayList;
import objNegocio.Jugador;

/**
 *
 * @author maairiim
 */
public class Jugadores {

    private static Jugadores instancia;
    private static ArrayList<Jugador> jugadoresList;

    private Jugadores() {
    }

    public static Jugadores getInstance() {
        if (jugadoresList == null) {
            instancia = new Jugadores();
            jugadoresList = new ArrayList<Jugador>();
        }
        return instancia;
    }
    
    public void addJugador(Jugador jugador){
        jugadoresList.add(jugador);
        
    }
    public void removeJugador(Jugador jugador){
        jugadoresList.remove(jugador);
    }
    
    public Jugador obtenerJugador(Jugador jugador){
        if(jugadoresList.contains(jugador)){
            return jugadoresList.get(jugador.getIdJugador());
        }else{
            return null;
        }        
    }
    
    public void actualizarJugadr(Jugador jugador){
        Jugador aux = obtenerJugador(jugador);
        if(obtenerJugador(jugador) != null){
            jugadoresList.add(jugadoresList.indexOf(aux), jugador);
        }else{
            System.out.println("El ususario no existe");
        }
    }
    
    public  ArrayList<Jugador> listaJugadores(){
        return jugadoresList;
    }
    

}
