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
            /*try {
                Thread.sleep(1000 + (20*id));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            buffer.write(id);

        }
    }
}
