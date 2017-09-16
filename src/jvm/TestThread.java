package jvm;

/**
 * Author ： Martin
 * Date : 17/8/7
 * Description :
 * Version : 2.0
 */
public class TestThread {
    public static void main(String[] args){
        MyThread myThread = new MyThread();
        // 将线程对象以构造参数的方式传递给Thread对象进行start（）启动线程
        Thread newThread = new Thread(myThread);
        newThread.setName("A");
        newThread.start();
    }
}
