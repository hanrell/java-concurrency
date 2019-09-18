import java.util.concurrent.Semaphore;

public class SingleBuffer {
    Semaphore s;
    Semaphore r;
    String value;
    String temp;

    public SingleBuffer(){
        s = new Semaphore(0, true);
        r = new Semaphore(1, true);
        value = null;
    }

    public void deposit(String v){
        r.acquireUninterruptibly();
        value = v;
        s.release();
    }

    public String fetch(){
        s.acquireUninterruptibly();
        temp = value;
        r.release();
        return temp;
    }
}
