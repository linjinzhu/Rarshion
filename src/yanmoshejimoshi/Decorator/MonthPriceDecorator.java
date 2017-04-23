package yanmoshejimoshi.Decorator;

import java.util.Date;

/**
 * Author ： Martin
 * Date : 17/3/22
 * Description :
 * Version : 2.0
 */
public class MonthPriceDecorator extends Decorator {

    public MonthPriceDecorator(Component component) {
        super(component);
    }

    @Override
    public double calPrize(String user, Date begin, Date end) {
        double money = super.calPrize(user, begin, end);
        double prize = money + 50.6;
        return prize;
    }
}
