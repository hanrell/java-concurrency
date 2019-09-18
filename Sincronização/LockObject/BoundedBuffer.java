import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
    int size, count;
    int inbuf, outbuf, i;
    String[] buffer;
    ReentrantLock lock;
    Condition empty, full;

    public BoundedBuffer(int size){
        this.size = size;
        count = 0;
        inbuf = 0;
        outbuf = 0;
        i = 0;
        buffer = new String[size];
        for(int i =0; i < size; i++) buffer[i] = null;
        lock = new ReentrantLock(true);
        empty = lock.newCondition();
        full = lock.newCondition();
    }

    public void write(int id){
        lock.lock();
        if(count == size) full.awaitUninterruptibly();
        buffer[inbuf] = "Teste " + String.valueOf(i);
        System.out.println(id + " Escrevendo na posição " + inbuf + ": " + buffer[inbuf]);
        inbuf = (inbuf + 1) % size;
        count++;
        i++;
        empty.signal();
        lock.unlock();
    }

    public String fetch(int id){
        String v;
        lock.lock();
        if(count == 0) empty.awaitUninterruptibly();
        v = buffer[outbuf];
        System.out.println(id + "Lendo da posição " + outbuf + ": " + buffer[outbuf]);
        outbuf = (outbuf + 1) % size;
        count--;
        full.signal();
        lock.unlock();
        return v;
    }
}
