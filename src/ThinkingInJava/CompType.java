package ThinkingInJava;

/**
 * Author ： Martin
 * Date : 17/4/24
 * Description :
 * Version : 2.0
 */
public class CompType implements Comparable<CompType> {

    int i;
    int j;
    private static int count = 1;

    public CompType(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public String toString() {
        String result = "[i =" + i + ", j = " + j + "]";
        if (count % 3 == 0) {
            result += "\n";
        }
        return result;
    }

    @Override
    public int compareTo(CompType o) {
        return (i < o.i ? -1 : (i == o.i ? 0 : 1));
    }

}
