/**
 * Linea.java
 */
package objetosNegocio;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class Linea extends FormaJuego {
    
    private Coordenada posicion;

    public Linea(Coordenada posicion, int indice, int width, int height, int x, int y) {
        super(null, indice, width, height, x, y);
        this.posicion = posicion;
    }

    public Linea(Coordenada posicion, Jugador jugador, int indice) {
        super(jugador, indice, 0, 0, 0, 0);
        this.posicion = posicion;
    }
    
    public Linea(Coordenada posicion, int indice){
        super(null, indice, 0, 0, 0, 0);
        this.posicion = posicion;
    }

    public Coordenada getPosicion() {
        return posicion;
    }

    public void setPosicion(Coordenada posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Linea{" + "posicion=" + posicion + "jugador=" + super.getJugador() + "indice" + super.getIndice() + '}';
    }
}