package ThinkingInJava;

/**
 * Created by rarshion on 16/8/21.
 */

class Meal{
    Meal(){
        System.out.println("Meal()");
    }
}

class  Bread{
    Bread(){
        System.out.println("Bread()");
    }
}

class Cheese{
    Cheese(){
        System.out.println("Cheese()");
    }
}

class Lettuce{
    Lettuce(){
        System.out.println("Lettuce()");
    }
}

class Lunch extends Meal{
    Lunch(){
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch{
    PortableLunch(){
        System.out.println("PortableLunch()");
    }
}

public class Sandwitch extends PortableLunch{

    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce t = new Lettuce();

    public Sandwitch(){
        System.out.println("Sandwitch()");
    }

    public static void main(String[] args){
        new Sandwitch();
        System.out.println(1>>1);
    }




}