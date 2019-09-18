import java.util.concurrent.Semaphore;

public class BoundedBuffer {
    int size, count;
    int inbuf;
    int outbuf;
    int i;
    String[] buffer;

    public BoundedBuffer(int size){
        this.size = size;
        inbuf = 0;
        outbuf = 0;
        count = 0;
        i = 0;
        buffer = new String[size];
        for (int i = 0; i < size; i++) buffer[i] = null;
    }

    public synchronized void deposit(int id) throws InterruptedException{
        if(count == size) wait();
        buffer[inbuf] = "Teste " + String.valueOf(i);
        System.out.println(id + " escrevendo na posição " + inbuf + ":" + buffer[inbuf]);
        i++;
        inbuf = (inbuf + 1) % size;
        count++;
        notify();
    }

    public synchronized String fetch(int id) throws InterruptedException {
        String value;
        if(count == 0) wait();
        value = buffer[outbuf];
        System.out.println(id + " lendo da posição " + outbuf + ":" + buffer[outbuf]);
        outbuf = (outbuf + 1) % size;
        count--;
        notify();
        return value;
    }
}
