public class MyThread extends Thread {
    MyLock lock;
    int id;

    public MyThread (MyLock lock, int id){
        this.lock = lock;
        this.id = id;
    }

    public void run (){
        while(true){
            lock.requestCS(id);
            System.out.println(getName() + " is in the CS");
            System.out.println("");
            lock.releaseCS(id);
        }
    }
}
