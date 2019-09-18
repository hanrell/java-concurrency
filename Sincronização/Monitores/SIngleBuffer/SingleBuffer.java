public class SingleBuffer {
    String value;
    boolean empty;

    public SingleBuffer() {
        value = null;
        empty = true;
    }

    public synchronized void deposit(String v) throws InterruptedException {
        if(!empty) wait();
        value = v;
        empty = false;
        notify();
    }

    public synchronized String fetch() throws InterruptedException {
        if (empty) wait();
        empty = true;
        notify();
        return value;
    }
}