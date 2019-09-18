import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Main {
    public static void main(String[] args) throws IOException {
        DatagramPacket in;
        DatagramSocket s = new DatagramSocket(4444);

        while (true){
            byte[] inbuf = new byte[256];
            in = new DatagramPacket(inbuf, inbuf.length);
            s.receive(in);

            new Thread(new ProtocolServer(s, in)).start();
        }
        //s.close();
    }
}