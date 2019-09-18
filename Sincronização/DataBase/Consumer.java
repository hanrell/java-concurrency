public class Consumer extends Thread {
    DataBase db;
    String data;

    public Consumer(DataBase db){
        this.db = db;
    }

    public void run(){
        while(true) {
            data = db.read();
            /*try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}
