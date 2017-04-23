package ThinkingInJava.CarBuilder;

/**
 * Created by rarshion on 16/9/23.
 */
abstract class Robot implements Runnable{

    private RobotPool pool;
    public Robot(RobotPool p){ this.pool = p;}
    protected  Assembler assembler;
    public Robot assignAssembler(Assembler assembler){
        this.assembler = assembler;
        return this;
    }

    private boolean engage = false;
    public synchronized void engage(){
        engage = true;
        notifyAll();
    }

    abstract protected void performService();
    public void run() {
        try {
            powerDown();
            while(!Thread.interrupted()) {
                performService();
                assembler.barrier().await();
                powerDown();
            }

        } catch (Exception ex) {

        }
    }

    private synchronized void powerDown() throws  InterruptedException{
        engage = false;
        assembler = null;

    }

    public String toString() {
        return getClass().getName();
    }
}
