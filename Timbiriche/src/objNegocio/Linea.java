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
public class Linea {
    private Coordenada puntoA;
    private Coordenada puntoB;

    public Linea(Coordenada puntoA, Coordenada puntoB) {
        this.puntoA = puntoA;
        this.puntoB = puntoB;
    }

    public Coordenada getPuntoA() {
        return puntoA;
    }

    public void setPuntoA(Coordenada puntoA) {
        this.puntoA = puntoA;
    }

    public Coordenada getPuntoB() {
        return puntoB;
    }

    public void setPuntoB(Coordenada puntoB) {
        this.puntoB = puntoB;
    }
    
    
    
}
