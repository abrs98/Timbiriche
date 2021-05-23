/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pipes;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 * @param <I> Entrada
 * @param <O> FiltroSalida
 */
interface Pipe<I, O> {
    void pasar(I objeto);
}