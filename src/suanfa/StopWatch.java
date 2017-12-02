package suanfa;

import java.text.SimpleDateFormat;

/**
 * Author ： Martin
 * Date : 17/9/27
 * Description :
 * Version : 2.0
 */
public class StopWatch {

    private long startTime;
    private long endTime;
    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    public StopWatch() {
        this.startTime=System.currentTimeMillis();
    }

    public void start() {
        this.startTime=System.currentTimeMillis();
        System.out.println("StartTimeIs:"+df.format(this.startTime));
    }

    public void end() {
        this.endTime=System.currentTimeMillis();
        System.out.println("EndTimeIs:"+df.format(this.endTime));
    }

    public long getStartTime(){
        return startTime;
    }

    public long getEndTime(){
        return endTime;
    }

    public long getElapsedTime(){
        return endTime - startTime;
    }

    public void setStartTime(long startTime){
        this.startTime=startTime;
    }

    public void setEndTime(long endTime){
        this.endTime=endTime;
    }

}
