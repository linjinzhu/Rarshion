package mianshi;

/**
 * Author ： Martin
 * Date : 17/3/28
 * Description :
 * Version : 2.0
 */
public class YinYong {

    public static void main(String[] args) {
        char ch[] = {'H', 'e', 'l', 'l', 'o'};
        change(ch);
        System.out.println(ch);
    }

    public static void change(char ch[]) {
        ch[0] = 'C';
    }
}
