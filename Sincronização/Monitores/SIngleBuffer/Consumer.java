public class Consumer extends Thread {
    SingleBuffer buffer;
    String value;

    public Consumer(SingleBuffer b){
        buffer = b;
    }

    public void run(){
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                value = buffer.fetch();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Lendo do buffer: " + value);
        }
    }
}
