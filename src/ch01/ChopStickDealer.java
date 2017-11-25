package ch01;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;

public class ChopStickDealer {

    private Table table;
    private Timer timer;
    private int taskCompletionTime;
    private int numberOfPhilosophers;

    public void ChopStickDealer(Table t){
        this.table=table;
        this.timer = new Timer();
        this.taskCompletionTime=3000;
        this.numberOfPhilosophers = 5;

        runPhilosophers();
    }

    private void subscribe(Philosopher f){
        table.subscribePhilosopher(f);
    }

    private void unSubscribe(Philosopher f){
        table.unSubscribePhilosopher(f);
    }

    private void runPhilosophers(){
        for (int i=0;i<numberOfPhilosophers;i++){
            Philosopher f = new Philosopher(Integer.toString(i));
            table.subscribePhilosopher(f);
        }
        setPhilosophersEating();
    }


    private void setPhilosophersEating(){
        DealerTask timerTask= new DealerTask();
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0,this.taskCompletionTime);
        System.out.println("The " + Integer.toString(this.numberOfPhilosophers) + "philosophers are eating...");

        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timer.cancel();
        System.out.println("DealerTask cancelled");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    private class DealerTask extends TimerTask{
        @Override
        public void run(){
            System.out.println("Timer task started at:"+new Date());
            completeTask();
            System.out.println("Timer task finished at:"+new Date());
        }

        private void completeTask() {
            try {
                //assuming it takes 20 secs to complete the task
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
