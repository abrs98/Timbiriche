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

   private Jugadores(){}

   public static Jugadores getInstance() {
       if (jugadoresList == null) {
           instancia  = new Jugadores();
           jugadoresList =  new ArrayList<Jugador>();
       }
       return instancia;
   }
   
   
   
    
}
