import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ProtocolClient {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn;
        stdIn = new BufferedReader(new InputStreamReader(System.in));

        DatagramPacket in, out;
        DatagramSocket s = new DatagramSocket();

        InetAddress server = InetAddress.getByName("localhost");

        while (true) {
            String fromUser = stdIn.readLine();
            byte[] outbuf = fromUser.getBytes();
            out = new DatagramPacket(outbuf, outbuf.length, server, 4444);
            s.send(out);

            byte[] inbuf = new byte[256];
            in = new DatagramPacket(inbuf, inbuf.length);
            s.receive(in);
            System.out.println(new String(in.getData(), 0, in.getLength()));

            if(fromUser.equals("Bye")) break;
        }

        s.close();
    }
}
