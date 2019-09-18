public class Main {
    public static void main(String[] args) {
        int philosophers = Integer.valueOf(args[0]);

        Table table = new Table(philosophers);

        for(int i = 0; i < philosophers; i++)
            (new Philosopher(table, i)).start();
    }
}
