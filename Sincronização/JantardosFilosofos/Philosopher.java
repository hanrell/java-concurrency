public class Philosopher extends Thread {
    Table table;
    int id;

    public Philosopher(Table table, int id){
        this.table = table;
        this.id = id;
    }

    public void run(){
        while(true){
            System.out.println("Filósofo " + id + " is thinking.");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Filósofo " + id + " is hungry.");
            table.acquire(id);
            System.out.println("Filósofo " + id + " is eating.");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            table.release(id);
        }
    }
}
