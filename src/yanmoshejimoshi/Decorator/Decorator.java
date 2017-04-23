package yanmoshejimoshi.Decorator;

import java.util.Date;

/**
 * Author ： Martin
 * Date : 17/3/22
 * Description :
 * Version : 2.0
 */
public abstract class Decorator extends Component {

    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public double calcPrize(String user, Date begin, Date end) {
        return component.calPrize(user, begin, end);
    }
}
