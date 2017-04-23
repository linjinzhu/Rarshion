package ThinkingInJava.CarBuilder;

/**
 * Created by rarshion on 16/9/23.
 */
public class Car {

    private final int id;
    private boolean engine = false, drivenTrain = false, wheels = false;

    public Car(int idn){
        this.id = idn;
    }

    public Car(){
        id = -1;
    }

    public synchronized int getId(){return id;}
    public synchronized void addEngine() {engine = true;}
    public synchronized void addDrivenTrain(){
        drivenTrain = true;
    }

    public synchronized void addWheels(){wheels = true;}
    public synchronized String toString(){
        return "Car" + id + " [" + "engine:" + engine
                + " drivenTrain:" + drivenTrain + " wheels:" + wheels + "]";
    }

}
