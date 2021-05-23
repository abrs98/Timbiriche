/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import objetosNegocio.Cuadro;
import objetosNegocio.FormaJuego;
import objetosNegocio.Jugador;
import objetosNegocio.Linea;
import DataTransferObjects.DataCuadrado;
import DataTransferObjects.DataJugador;
import DataTransferObjects.DataLinea;
import DataTransferObjects.DataMensaje;
import DataTransferObjects.Movimiento;
import java.io.IOException;
import java.util.List;
import utileria.IActualizable;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class Cliente implements ICliente {

    private static Cliente instance;

    private SocketCliente sckCliente;

    public Cliente(Jugador jugador, IActualizable actualizable) {
        this.sckCliente = SocketCliente.getInstance(jugador, actualizable);
    }

    @Override
    public boolean conectarAlServidor(String address, int port) {
        try {
            sckCliente.conectarAlServidor(address, port);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    @Override
    public boolean enviarAlServidor(Object mensaje) {
        try {
            if (mensaje instanceof Jugador) {
                Jugador jugador = (Jugador) mensaje;
                DataJugador mensajeNuevo = new DataJugador(jugador.getNombre(), jugador.getPuntaje());
                sckCliente.enviarAlServidor(mensajeNuevo);
                System.out.println("Jugador > "+mensajeNuevo.toString());
                return true;
            } else if (mensaje instanceof List) {
                Movimiento movimiento = new Movimiento();
                List<FormaJuego> formas = (List<FormaJuego>) mensaje;

                for (int i = 0; i < formas.size(); i++) {
                    if (i == 0) {
                        Linea linea = (Linea) formas.get(i);
                        DataLinea formaNueva
                                = new DataLinea(
                                        linea.getPosicion().toString(),
                                        linea.getIndice(),
                                        new DataJugador(
                                                linea.getJugador().getNombre(),
                                                linea.getJugador().getPuntaje()));
                        movimiento.setLinea(formaNueva);
                    } else {
                        Cuadro cuadro = (Cuadro) formas.get(i);
                        DataCuadrado formaNueva
                                = new DataCuadrado(
                                        cuadro.getIndice(),
                                        new DataJugador(
                                                cuadro.getJugador().getNombre(),
                                                cuadro.getJugador().getPuntaje()));
                        movimiento.setCuadro(formaNueva);
                    }
                }

                sckCliente.enviarAlServidor(movimiento);
                return true;
            } else if (mensaje instanceof String) {
                sckCliente.enviarAlServidor(mensaje);
                return true;
            } else if (mensaje instanceof DataMensaje) {
                sckCliente.enviarAlServidor(mensaje);
                return true;
            }
            return false;
        } catch (IOException ex) {
            return false;
        }
        
    }

    @Override
    public void escucharAlServidor() {
        try {
            sckCliente.escucharAlServidor();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Problemas al recibir la respuesta del servidor");
        }
    }
}
