public class LockImpl implements MyLock {
    volatile boolean wantCS[] = {false, false};
    volatile int turn = 1;

    @Override
    public void requestCS(int id) {
        int otherID = 1 - id;
        wantCS[id] = true;

        /**Dekker*/
        /*while (wantCS[otherID]){
            if (turn == otherID){
                wantCS[id] = false;
                while (turn == otherID);
                wantCS[id] = true;
            }
        }*/

        /**Peterson*/
        turn = otherID;
        while (wantCS[otherID] && turn == otherID);
        //try {Thread.sleep(200);} catch (Exception e){}

    }

    @Override
    public void releaseCS(int id) {
        turn = 1 - id;
        wantCS[id] = false;
    }
}
