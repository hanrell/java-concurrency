public class Main {
    public static void main(String[] args) {
        MyLock lock = new LockImpl();

        MyThread t1 = new MyThread(lock, 0);
        MyThread t2 = new MyThread(lock, 1);

        t1.start();
        t2.start();
    }
}
