public class Producer extends Thread {
    DataBase db;
    String data;

    public Producer(DataBase db){
        this.db = db;
    }

    public void run(){
        while (true){
            db.write();
           /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}
