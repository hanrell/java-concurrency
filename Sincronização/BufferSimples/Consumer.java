public class Consumer extends Thread {
    SingleBuffer buffer;
    String value;

    public Consumer(SingleBuffer b){
        buffer = b;
    }

    public void run(){
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            value = buffer.fetch();
            System.out.println("Lendo do buffer: " + value);
        }
    }
}
