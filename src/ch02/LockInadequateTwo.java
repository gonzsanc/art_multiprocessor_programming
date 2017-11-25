package ch02;

/**
 * The problem of this thread is that it only is good if both threads run concurrently.
 */
public class LockInadequateTwo implements Lock{
    private int victim;

    public void lock() {
        int i =  ThreadID.get();
        victim = i;
        while (victim == i) {}
    }
    public void unlock(){}

}

