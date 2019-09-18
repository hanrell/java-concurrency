public class Producer extends Thread{
    SingleBuffer buffer;
    String value;

    public Producer(SingleBuffer b){
        buffer = b;
    }

    public void run(){
        int i = 0;
        while(true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            value = "Teste " + String.valueOf(i++);
            try {
                buffer.deposit(value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Escrevendo no buffer: " + value);
        }
    }
}
