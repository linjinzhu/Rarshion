package yanmoshejimoshi.Decorator;

import java.util.Date;

/**
 * Author ： Martin
 * Date : 17/3/22
 * Description :
 * Version : 2.0
 */
public class SumPrizeDecorator extends Decorator {
    public SumPrizeDecorator(Component component) {
        super(component);
    }

    public double calPrize(String user, Date begin, Date end) {
        double money = super.calPrize(user, begin, end);
        double prize = money + 1000.5;
        return prize;
    }
}
