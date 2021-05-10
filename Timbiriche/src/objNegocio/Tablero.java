/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objNegocio;

import java.util.ArrayList;

/**
 *
 * @author maairiim
 */
public class Tablero {
    private int cantJugadores;
    private ArrayList <Casilla> cantCasillas;
    private ArrayList <Linea> LineasMarcadas;

    public Tablero(int cantJugadores) {
        this.cantJugadores = cantJugadores;
    }
    /*
    HACE FALTA MODIFICAR LOS SETTERS
    */

    public int getCantJugadores() {
        return cantJugadores;
    }

    public void setCantJugadores(int cantJugadores) {
        this.cantJugadores = cantJugadores;
    }

    public ArrayList<Casilla> getCantCasillas() {
        return cantCasillas;
    }

    public void setCantCasillas(ArrayList<Casilla> cantCasillas) {
        this.cantCasillas = cantCasillas;
    }

    
    
    
    
    
}
