public class Main {
    public static void main(String[] args) {

        SingleBuffer b = new SingleBuffer();
        Producer p = new Producer(b);
        Consumer c = new Consumer(b);

        p.start();
        c.start();
    }
}
