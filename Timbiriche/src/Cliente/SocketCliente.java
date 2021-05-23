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
import objetosNegocio.Scorer;
import objetosNegocio.Coordenada;
import DataTransferObjects.DataCuadrado;
import DataTransferObjects.DataJugador;
import DataTransferObjects.DataLinea;
import DataTransferObjects.DataScorer;
import DataTransferObjects.Movimiento;
import DataTransferObjects.DataResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import utileria.IActualizable;

/**
 *
 * @author Abrahan Barrios, Victor Torres, Ana Rios
 */
public class SocketCliente implements Runnable {

    private Jugador jugador;
    private Socket socket;
    private ObjectInputStream clientInput;
    private ObjectOutputStream clientOutput;
    private IActualizable actualizable;
    private Object objeto;

    private static SocketCliente instance;

    private SocketCliente(Jugador jugador, IActualizable actualizable) {
        this.jugador = jugador;
        this.actualizable = actualizable;
    }

    public static SocketCliente getInstance(Jugador jugador, IActualizable actualizable) {
        if (instance == null) {
            instance = new SocketCliente(jugador, actualizable);
        } else {
            instance.actualizable = actualizable;
        }
        return instance;
    }

    public synchronized void conectarAlServidor(String address, int port) throws IOException {
        socket = new Socket(address, port);
        clientOutput = new ObjectOutputStream(socket.getOutputStream());
        clientOutput.flush();
        clientInput = new ObjectInputStream(socket.getInputStream());
    }

    public synchronized void enviarAlServidor(Object mensaje) throws IOException {
        clientOutput.writeObject(mensaje);
        clientOutput.flush();
    }

    public synchronized void escucharAlServidor() throws IOException, ClassNotFoundException {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                objeto = clientInput.readObject();

                if (objeto instanceof List) {
                    List<DataJugador> jugadoresDTO = (List<DataJugador>) objeto;
                    List<Jugador> jugadores = new ArrayList<>();

                    for (DataJugador jugador : jugadoresDTO) {
                        jugadores.add(new Jugador(jugador.getNombreJugador(),jugador.getPuntaje()));
                    }

                    objeto = jugadores;
                } else if (objeto instanceof String) {
                    String string = (String) objeto;
                    objeto = string;
                } else if (objeto instanceof DataScorer) {
                    DataScorer marcadorDTO = (DataScorer) objeto;
                    List<DataJugador> jugadoresDTO = marcadorDTO.getJugadores();
                    List<Jugador> jugadores = new ArrayList<>();

                    for (DataJugador jugador : jugadoresDTO) {
                        jugadores.add(new Jugador(jugador.getNombreJugador(), jugador.getPuntaje()));
                    }

                    Scorer marcador = new Scorer(jugadores);

                    objeto = marcador;
                } else if (objeto instanceof DataResponse) {
                    Movimiento movimiento = ((DataResponse) objeto).getMovimiento();
                    List<FormaJuego> formas = new ArrayList<>();

                    if (movimiento.getLinea() != null) {
                        DataLinea dataLinea = movimiento.getLinea();

                        Linea linea = new Linea(
                                Coordenada.valueOf(dataLinea.getPosicion()),
                                new Jugador(
                                        dataLinea.getJugador().getNombreJugador(),
                                        dataLinea.getJugador().getPuntaje()),
                                dataLinea.getIndice());

                        formas.add(linea);
                    }

                    for (DataCuadrado cuadroDTO : movimiento.getCuadros()) {
                        Cuadro cuadro = new Cuadro(
                                new Jugador(
                                        cuadroDTO.getJugador().getNombreJugador(),
                                        cuadroDTO.getJugador().getPuntaje()),
                                cuadroDTO.getIndice());

                        formas.add(cuadro);
                    }
                    System.out.println("Se intenta agregar jugador");
                    DataScorer marcadorDTO = ((DataResponse) objeto).getMarcador();
                    System.out.println("MarcadorDTO " + marcadorDTO);
                    List<DataJugador> jugadoresDTO = marcadorDTO.getJugadores();
                    List<Jugador> jugadores = new ArrayList<>();

                    for (DataJugador jugador : jugadoresDTO) {
                        jugadores.add(new Jugador(jugador.getNombreJugador(), jugador.getPuntaje()));
                 
                    }

                    Scorer marcador = new Scorer(jugadores);
                    System.out.println(marcador);
                    objeto = marcador;

                    //Solo para enviar el marcador
                    mostrarCambios();

                    objeto = formas;
                }

                mostrarCambios();

                System.out.println(objeto);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private synchronized void mostrarCambios() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                actualizable.actualizaDeSocket(objeto);
            }
        });
    }
}
