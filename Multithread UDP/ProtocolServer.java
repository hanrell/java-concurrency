import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/** O servidor agora é uma thread.
 */

public class ProtocolServer implements Runnable {
    DatagramSocket s;
    DatagramPacket p;
    Protocol protocol = new Protocol();

    public ProtocolServer(DatagramSocket socket, DatagramPacket packet){
        s = socket;
        p = packet;
    }

    public void run() {
        DatagramPacket out;

        String fromClient = new String(p.getData(), 0, p.getLength());

        InetAddress client = p.getAddress();
        int port = p.getPort();

        byte[] outbuf = protocol.processLine(fromClient).getBytes();
        out = new DatagramPacket(outbuf, outbuf.length, client, port);
        try {
            s.send(out);
        } catch (IOException e){
            System.out.println("error");
        }
    }
}