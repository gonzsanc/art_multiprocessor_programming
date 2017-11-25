package ch02;

/**
 * Peterson Algorithm is deadlock-free.
 */
public class Peterson implements Lock {

    private boolean[] flag = new boolean[2];
    private int victim;

    public void lock(){
        int i=ThreadID.get();
        int j = 1 - i;
        flag[i]=true; //I'm interested.
        victim = i; //you go first.
        while (flag[j] && victim==i){}; //wait
    }
    public void unlock(){
        int i = ThreadID.get();
        flag[i]=false; //I am not interested.
    }


}
