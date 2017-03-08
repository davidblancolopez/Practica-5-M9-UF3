package practica.pkg5.m9.uf3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServidorUDP {

    public static void main(String args[]) {

        try {

            //Es crea el socket.
            DatagramSocket socket = new DatagramSocket(6789);
            //Es crea l'array de bytes.
            byte[] buffer = new byte[1000];

            while (true) {
                //Es crea el DatagramPacket per a poder rebre missatges.
                DatagramPacket peticion
                        = new DatagramPacket(buffer, buffer.length);

                // Es llegim la petició del socket
                socket.receive(peticion);

                System.out.print("Datagrama recibido del host: "
                        + peticion.getAddress());
                System.out.println(" desde el puerto remoto: "
                        + peticion.getPort());

                //Es construeix el DatagramPacket per respondre.
                DatagramPacket respuesta
                        = new DatagramPacket(peticion.getData(), peticion.getLength(),
                                peticion.getAddress(), peticion.getPort());

                //S'envia la resposta.
                socket.send(respuesta);
            }

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

}
