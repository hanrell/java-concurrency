public class Main {
    public static void main(String[] args) {
        int nr = Integer.parseInt(args[0]);
        int nw = Integer.parseInt(args[1]);

        DataBase db = new DataBase();
        for (int i = 0; i < nr; i++)
            (new Consumer(db)).start();
        for (int i = 0; i < nw; i++)
            (new Producer(db)).start();
    }
}
