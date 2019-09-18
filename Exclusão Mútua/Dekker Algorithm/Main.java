public class Main {
    public static void main(String[] args) {
        MyLock lock = new LockImpl();

        MyThread t1 = new MyThread(lock, 0);
        MyThread t2 = new MyThread(lock, 1);

        t1.start();
        //try {t1.sleep(10000);} catch (Exception e){}
        t2.start();
    }
}