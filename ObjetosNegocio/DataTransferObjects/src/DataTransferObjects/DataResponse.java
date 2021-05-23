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
public class DataResponse implements Serializable{
    private Movimiento movimiento;
    private DataScorer marcador;

    public DataResponse(Movimiento movimiento, DataScorer marcador) {
        this.movimiento = movimiento;
        this.marcador = marcador;
    }

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public DataScorer getMarcador() {
        return marcador;
    }

    public void setMarcador(DataScorer marcador) {
        this.marcador = marcador;
    }
}