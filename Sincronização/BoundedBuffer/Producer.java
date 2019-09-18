public class Producer extends Thread{
    BoundedBuffer buffer;
    String value;
    int id;

    public Producer(BoundedBuffer b, int id){
        buffer = b;
        this.id = id;
    }

    public void run(){
        while(true) {
            buffer.deposit(id);
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}
