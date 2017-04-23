package jvm;

/**
 * Created by rarshion on 17/1/11.
 */
public class ScratImpl {
    private static ScratImpl inst = null;
    private ScratImpl() {

    }

    private void run() {

    }

    public static void main(String[] args) {
//        inst = new ScratImpl();
//        inst.run();

        String str = "foo";
        if (args.length > 0)
            str = args[0];
        System.out.println("this is my string:" + str);
    }
}
