package java8InAction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author ： Martin
 * Date : 17/6/12
 * Description :
 * Version : 2.0
 */
public class MainTest {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> tr2011 =
                transactions.stream()
                            .filter(transaction -> transaction.getYear() == 2011)
                            .sorted(Comparator.comparing(Transaction::getValue))
                            .collect(Collectors.toList());

        
    }
}
