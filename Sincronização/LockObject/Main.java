public class Main {
    public static void main (String[] args) {
        int size = Integer.parseInt(args[0]);
        int nprod = Integer.parseInt(args[1]);
        int ncons = Integer.parseInt(args[2]);
        BoundedBuffer b = new BoundedBuffer(size);
        for (int i =0; i < nprod; i++) (new Producer(b, i)).start();
        for (int i =0; i < ncons; i++) (new Consumer(b, i)).start();
    }
}