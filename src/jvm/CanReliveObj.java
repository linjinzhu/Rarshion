package jvm;

/**
 * Created by user on 2016/8/3.
 */
public class CanReliveObj {
    public static CanReliveObj obj;

    protected  void finalize() throws  Throwable{
        super.finalize();
        System.out.println("CanReliveObj finalize call");
        obj = this;
    }

    public String toString(){
        return "I am CanReliveObj";
    }

    public static void main(String[] args) throws InterruptedException {
        obj = new CanReliveObj();
        obj = null;
        System.gc();
        Thread.sleep(1000);
        if(obj == null){
            System.out.println("obj 是null");
        }else{
            System.out.println("obj 可用");
        }

    }
}
