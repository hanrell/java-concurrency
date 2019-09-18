public class Main {
    public static void main(String[] args) throws InterruptedException {

        SingleBuffer b = new SingleBuffer();
        Producer p = new Producer(b);
        Consumer c = new Consumer(b);

        c.start();
        p.start();

    }
}
