package ThinkingInJava.CarBuilder;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rarshion on 16/9/23.
 */
public class RobotPool {

    private Set<Robot> pool = new HashSet<>();
    public synchronized void add(Robot r){
        pool.add(r);
        notifyAll();
    }

    public synchronized void hire(Class<? extends Robot> robotType, Assembler d){

        for(Robot r : pool){
            if(r.getClass().equals(robotType)){
                pool.remove(r);
            }
        }
    }

    public synchronized void release(Robot r) {
        add(r);
    }
}
