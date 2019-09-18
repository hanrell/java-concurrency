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
            /*try {
                Thread.sleep(2500 + (20 * id));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            value = buffer.fetch(id);

        }
    }
}
