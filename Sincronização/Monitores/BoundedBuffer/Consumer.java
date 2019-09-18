public class Consumer extends Thread {
    BoundedBuffer buffer;
    String value;
    int id;

    public Consumer(BoundedBuffer b, int id){
        buffer = b;
        this.id = id;
    }

    public void run(){
        while(true) {
            try {
                value = buffer.fetch(id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
