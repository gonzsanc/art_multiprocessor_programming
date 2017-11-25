package ch02;

/**
 * Counter for shared use.
 */
public class Counter{
    private long value;
    private Lock lock;

    /**
     * The new counter will start with an initial value.
     * @param c an integer value to initialize the status of the counter.
     */
    public  Counter(long c){
        value=c;
    }

    /**
     * Access to the counter value. When it is got, the internal counter value increments by one.
     * @return a numerical value with the current value of the counter.
     */
    public long getAndIncrement(){
        lock.lock();
        try {
            long temp = value;
            value = temp + 1;
            return temp;
        }finally {
            lock.unlock();
        }
    }
}
