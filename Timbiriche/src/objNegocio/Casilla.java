/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objNegocio;

/**
 *
 * @author maairiim
 */
public class Casilla {
    private Linea[] casilla;

    public Casilla(Linea[] casilla) {
        this.casilla = casilla;
    }

    public Linea[] getCasilla() {
        return casilla;
    }

    public void setCasilla(Linea[] casilla) {
        this.casilla = casilla;
    }
    
    
    
}
