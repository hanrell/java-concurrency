public class Main {
    public static void main(String[] args) {
        int size =Integer.parseInt(args[0]);

        BoundedBuffer b = new BoundedBuffer(size);
        Producer p = new Producer(b,1);
        Consumer c = new Consumer(b, 1);
        Producer p1 = new Producer(b, 2);
        Consumer c1 = new Consumer(b, 2);

        c.start();
        p.start();
        c1.start();
        p1.start();
    }
}