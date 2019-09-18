import java.util.concurrent.Semaphore;

public class BoundedBuffer {
    int size;
    int inbuf;
    int outbuf;
    int i;
    String[] buffer;
    Semaphore empty, full, mutex;

    public BoundedBuffer(int size){
        this.size = size;
        empty = new Semaphore(size);
        full = new Semaphore(0);
        mutex = new Semaphore(1);
        inbuf = 0;
        outbuf = 0;
        i = 0;
        buffer = new String[size];
        for (int i = 0; i < size; i++) buffer[i] = null;
    }

    public void deposit(int id){
        empty.acquireUninterruptibly();
        mutex.acquireUninterruptibly();
        buffer[inbuf] = "Teste " + String.valueOf(i);
        System.out.println(id + " escrevendo na posição " + inbuf + ":" + buffer[inbuf]);
        i++;
        inbuf = (inbuf + 1) % size;
        mutex.release();
        full.release();
    }

    public String fetch(int id){
        String value;
        full.acquireUninterruptibly();
        mutex.acquireUninterruptibly();
        value = buffer[outbuf];
        System.out.println(id + " lendo da posição " + outbuf + ":" + buffer[outbuf]);
        outbuf = (outbuf + 1) % size;
        mutex.release();
        empty.release();
        return value;
    }
}
