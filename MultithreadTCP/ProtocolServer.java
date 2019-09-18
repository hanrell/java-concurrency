/**O seu servidor é agora uma thread. O que essa thread deve fazer?
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ProtocolServer implements Runnable {
    Socket ns;

    public ProtocolServer(Socket ns) {
        this.ns = ns;
    }

    public void run() {
        try {
            DataInputStream in = new DataInputStream(ns.getInputStream());
            DataOutputStream out = new DataOutputStream(ns.getOutputStream());
            while (true) {
                String fromClient = in.readUTF();
                Protocol protocol = new Protocol();
                out.writeUTF(protocol.processLine(fromClient));
                if (fromClient.equals("Bye")) break;
            }
            in.close();
            out.close();
            ns.close();
        } catch (java.io.IOException e) {
            System.out.println("erro");
        }
    }
}
