package java8InAction;

/**
 * Author ： Martin
 * Date : 17/6/12
 * Description :
 * Version : 2.0
 */
public class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }
    public String getName(){
        return this.name;
    }
    public String getCity(){
        return this.city;
    }

    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}
