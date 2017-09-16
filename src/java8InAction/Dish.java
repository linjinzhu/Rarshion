package java8InAction;

/**
 * Author ： Martin
 * Date : 17/6/20
 * Description :
 * Version : 2.0
 */
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public enum Type {
        MEAT, FISH, OTHER
    }

    public Dish(String name, boolean vegetarian, int caloria, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = caloria;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public boolean isVegetarian() {
        return vegetarian;
    }
    public int getCalories() {
        return calories;
    }
    public Type getType() {
        return type;
    }
}
