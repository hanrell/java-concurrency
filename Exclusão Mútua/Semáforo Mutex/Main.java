import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int nproc = 10;
        Semaphore s = new Semaphore(1, true);

        for (int i = 0; i < nproc; i++){
            (new MyLock(s,i)).start();
        }
    }
}
