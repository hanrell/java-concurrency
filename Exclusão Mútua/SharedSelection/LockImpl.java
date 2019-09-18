public class LockImpl implements MyLock {
    volatile int turn = 0;

    public void requestCS(int id){
        while (turn == 1 - id);

    }

    public void releaseCS(int id){
        turn = 1 - id;
    }
}
