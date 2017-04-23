package yanmoshejimoshi.Decorator;

import java.util.Date;

/**
 * Author ： Martin
 * Date : 17/3/22
 * Description :
 * Version : 2.0
 */
public class TestDecorator {
    public static void main(String[] args) {
        Component c = new CreateComponent();
        Decorator d1 = new MonthPriceDecorator(c);
        Decorator d2 = new SumPrizeDecorator(d1);
        System.out.println(d2.calcPrize("zhangsan", new Date(), new Date()));
    }
}
