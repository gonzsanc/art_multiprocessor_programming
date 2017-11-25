package ch02;

/**
 * <p>This is an on purpose incorrect lock implementation.</p>
 * <p>The threads have ids 0 and 1, the calling thread has i, and the other j = 1 - i.
 * Each thread acquires its index by calling ThreadID.get().</p>
 * <p>In practice, the Boolean flag variables in LockInadequateOne , as well  as the victim and label
 * variables in later algorithms must all be declared volatile to work properly.
 * The Java volatile keyword guarantees visibility of changes to variables
 * across threads writing the value of the variable in RAM memory iof local CPU cache.</p>
 * <p>The main problem with this approach is that the class may deadlock the thread.
 * There is no lock freedom implementation.</p>
 */
public class LockInadequateOne implements Lock{

    private boolean[] flag = new boolean[2];

    public void lock(){
        int i = ThreadID.get();
        int j = 1 - i;
        flag[i]=true;
        while (falg[j]){} //wait
    }

    public void unlock(){
        int i = ThreadID.get();
        flag[i]=false;
    }
}
