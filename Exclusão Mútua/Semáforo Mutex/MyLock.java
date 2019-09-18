import java.util.concurrent.Semaphore;

public class MyLock extends Thread {
    Semaphore s;
    int id;

    public MyLock (Semaphore s, int id){
        this.s = s;
        this.id = id;
    }

    public void run() {
        while (true){
            try {
                s.acquire();
                System.out.println("Processo " + id);
                System.out.println("");
                Thread.sleep(100 + (20*id));
                s.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
