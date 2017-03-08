
package practica.pkg5.m9.uf3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class ClienteUDP {
    
    public static void main(String args[]) {

    try {
      DatagramSocket socket = new DatagramSocket();
      byte[] mensaje = args[0].getBytes();
      InetAddress hostServidor = InetAddress.getByName(args[1]);
      int puertoServidor = 6789;

      //Construim un DatagramPacket per enviar un missatge al servidor.
      DatagramPacket peticion =
        new DatagramPacket(mensaje, args[0].length(), hostServidor,
                           puertoServidor);

      //S'envia el DatagramPacket.
      socket.send(peticion);

      //Es construeix el DatagramPacket on es guardaran la resposta del servidor
      byte[] buffer = new byte[1000];
      DatagramPacket resposta =
        new DatagramPacket(buffer, buffer.length);
      socket.receive(resposta);

      //Mostrem la resposta del servidor.
      System.out.println("Resposta del servidor: " + new String(resposta.getData()));

      // Cerramos el socket
      socket.close();

    } catch (SocketException e) {
      System.out.println("Socket: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO: " + e.getMessage());
    }
  }
    
    
}
