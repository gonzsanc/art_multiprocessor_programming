/**
 * A consumer that can handle one chopstick.
 */
public class Philosopher implements IChopStickConsumer {

    /**
     * Philosopher's name.
     */
    public String name;

    private ChopStick chopstick;

    /**
     * Each time the timer runs this is incremented by 1 if the philosopher is holding a stick.
     */
    public int timeSpentHoldingChopStick;


    /**
     * When creating a philosopher, it is required to give it a name.
     * The initial chopsticks are set to null and the timeSpentHoldingChopStick counter to zero.
     * @param name any name for the philosopher.
     */
    public Philosopher(String name){
        this.name=name;
        this.chopstick=null;
        this.timeSpentHoldingChopStick=0;
    }

    /**
     * Method to be called when assigning a chopstick to the philosopher.
     * A philosopher can handle only one stick at a time.
     * @param c a ChopStick object.
     */
    public void takeChopStick(ChopStick c ){
        this.chopstick=c;
    }

    /**
     * Returns the chopstick held by the philosopher.
     * The philosopher is not holding anymore the stick after returning it.
     * @return a CandleStick object if held by the philosopher. "null" otherwise.
     */
    public ChopStick returnChopStick(){
        ChopStick c = new ChopStick();
        c.id=this.chopstick.id;
        chopstick=null;
        this.timeSpentHoldingChopStick=0;
        return c;
    }

    /**
     * Returns the id of the chopstick held by the philosopher.
     * @return the string with the name or null if the philosopher does not have any stick.
     */
    public String getChopstickID(){
        if (this.chopstick==null){
            return null;
        }else{
            return this.chopstick.id;
        }
    }
}
