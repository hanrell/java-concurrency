import java.util.concurrent.Semaphore;

public class Table {
    Semaphore[] fork;
    Semaphore mutex;
    int seats;

    public Table (int seats){
        this.seats = seats;
        fork = new Semaphore[seats];
        mutex = new Semaphore(1);
        for (int i = 0; i < seats; i++) fork[i] = new Semaphore(1);
    }

    public void acquire(int id){
        mutex.acquireUninterruptibly();
        fork[id].acquireUninterruptibly();
        fork[(id + 1)%seats].acquireUninterruptibly();
        mutex.release();
    }

    public void release (int id){
        fork[id].release();
        fork[(id +1)%seats].release();
    }
}
