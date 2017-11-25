package ch01;
import java.util.*;
import java.util.HashSet;

public class Table {

    public HashSet<ChopStick> chopsTickRepository;
    public HashSet<Philosopher>  subscriptions;
    private int numberOfChopSticks;

    // CONSTRUCTOR
    public void Table(){
        this.numberOfChopSticks=(5);
    }

    public void Table(int n){
        this.numberOfChopSticks=n;
        HashSet subscriptions = new HashSet<Philosopher>();
        resetChopSticks();
    }

    // INITIALIZER
    private void resetChopSticks(){
        this.chopsTickRepository = new HashSet<ChopStick>();
        for (int i=0;i<this.numberOfChopSticks;i++){
            ChopStick c = new ChopStick();
            c.id= Integer.toString(i);
            chopsTickRepository.add(c);
        }
    }

    public int getRemainingChopSticks(){
        return this.chopsTickRepository.size();
    }

    // Returns either one available chopstick or null if there are no available chopsticks.
    public ChopStick takeChopStick(){

        if (this.chopsTickRepository.isEmpty()) return null;
        else {
            ChopStick c = this.chopsTickRepository.iterator().next();
            this.chopsTickRepository.remove(c);
            return c;
        }
    }

    public void subscribePhilosopher(Philosopher f){
        subscriptions.add(f);
    }

    public void unSubscribePhilosopher(Philosopher f){
        if (subscriptions.contains(f)) {
            subscriptions.remove(f);
        }
    }

    public HashSet<Philosopher> getSubscriptors(){
        return this.subscriptions;
    }

}
