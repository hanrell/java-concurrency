import java.util.concurrent.Semaphore;

public class DataBase {
    Semaphore mutex, wlock, queue;
    int numReaders;
    String data;
    int i;

    public DataBase (){
        mutex = new Semaphore(1);
        wlock = new Semaphore(1);
        queue = new Semaphore(1);
        numReaders = 0;
        i = 0;
    }

    public void write (){
        queue.acquireUninterruptibly();
        wlock.acquireUninterruptibly();
        queue.release();
        data = "Teste " + String.valueOf(i++);
        System.out.println("Escrevendo no banco: " + data);
        wlock.release();
    }

    public String read(){
        String v;
        queue.acquireUninterruptibly();
        mutex.acquireUninterruptibly();
        numReaders++;
        if(numReaders == 1) wlock.acquireUninterruptibly();
        mutex.release();
        queue.release();
        v = data;
        System.out.println("Lendo do banco: " + data);
        mutex.acquireUninterruptibly();
        numReaders--;
        if(numReaders == 0) wlock.release();
        mutex.release();
        return v;
    }
}
