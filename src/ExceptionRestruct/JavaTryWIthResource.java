package ExceptionRestruct;

import java.io.IOException;

/**
 * Author ： Martin
 * Date : 17/6/14
 * Description :
 * Version : 2.0
 */
public class JavaTryWIthResource {


    public static void cleanupFailureInTryWithResources() throws Exception {
        try (MyOutputStream mos = new MyOutputStream();
            MyConnectionException mc = new MyConnectionException();
            MyInputStream mis = new MyInputStream()) {
            throw new IOException("Function Failure");
        }
    }


    public static void JavaTryWIthResource() throws Exception {
        try(MyOutputStream mos = new MyOutputStream()) {
            throw new IOException("Function fail");
        }
    }

    public static void main(String[] args) {
//        try {
////            JavaTryWIthResource();
//            cleanupFailureInTryWithResources();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Throwable[] ta = e.getSuppressed();
//            System.err.println("Suppressed exception" + "size = " + ta.length);
//        }

//        List<Integer> test = Arrays.asList(1,2,3,4,5,6,7);
//        System.out.println(test.size());
//        List<Integer> t1 = test.subList(0,3);
//        List<Integer> t2 = test.subList(7,7);

        try {
            throw new IOException();
        } catch (IOException ex) {

        }
        System.out.println("2");
        return;

    }
}
