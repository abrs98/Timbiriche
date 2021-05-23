package DataTransferObjects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Abrahan Barrios
 */
public abstract class GestorMovimiento {
    protected Movimiento movimiento;
    
    public Movimiento getMovimientoDTO(){
        return movimiento;
    }
    
    public void creaMovimientoDTO(){
        movimiento = new Movimiento();
    }
    
    public void agregarLinea(DataLinea linea){};
    
    public void agregarCuadro(DataCuadrado cuadro){};
}
