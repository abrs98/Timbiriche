package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author  Abrahan Barrios, Victor Torres, Ana Rios
 */
public class SckServer {

    static volatile List<SckServerThread> threads = new ArrayList<>();

    static int MAX = 2;

    private SckServerProtocol ssp = new SckServerProtocol();
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5555);
        
        System.out.println("Servidor Activo en puerto 5555");

        Socket s;

        while (true) {
            s = ss.accept();

            if (threads.size() < MAX) {
                System.out.println("Nueva conexion por parte de cliente: " + s);

                SckServerThread sst = new SckServerThread(s, threads, MAX);

                Thread t = new Thread(sst);

                threads.add(sst);

                t.start();
            } else {
                System.out.println("Servidor lleno. Máximo número de conexiones simultaneas");
            }
        }
    }
}
