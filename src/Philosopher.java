public class Philosopher implements IChopStickConsumer {

    public String name;
    private ChopStick chopstick;
    public int timeSpentHoldingChopStick;

    public Philosopher(String name){
        this.name=name;
        this.chopstick=null;
        this.timeSpentHoldingChopStick=0;
    }

    public void takeChopStick(ChopStick c ){
        this.chopstick=c;
    }

    public ChopStick returnChopStick(){
        ChopStick c = new ChopStick();
        c.id=this.chopstick.id;
        chopstick=null;
        this.timeSpentHoldingChopStick=0;
        return c;
    }

    public String getChopstickID(){
        if (this.chopstick=null){
            return null;
        }else{
            return this.chopstick.id;
        }
    }
}
