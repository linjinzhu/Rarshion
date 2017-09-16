package java8InAction;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Author ： Martin
 * Date : 17/6/28
 * Description :
 * Version : 2.0
 */
public class TransactionTest {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactionList = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //找出2011年的所有交易并按交易额进行升序排序
        List<Transaction> tr2011 =
                transactionList.stream()
                               .filter(transaction -> transaction.getYear() == 2011)
                               .sorted(Comparator.comparing(Transaction::getValue))
                               .collect(Collectors.toList());

        //交易员都在哪些不同的城市工作过
        List<String> cities =
                transactionList.stream()
                               .map(transaction -> transaction.getTrader().getCity())
                               .distinct()
                               .collect(Collectors.toList());

        //查找所有来自剑桥的交易员,并按姓名排序
        List<Trader> traders =
                transactionList.stream()
                               .map(Transaction::getTrader)
                               .filter(trader -> trader.getCity().equals("Cambridge"))
                               .sorted(Comparator.comparing(Trader::getName))
                               .collect(Collectors.toList());

        //返回所有交易员的姓名字符串,按字母排序
        String traderStr =
                transactionList.stream()
                               .map(transaction -> transaction.getTrader().getName())
                               .distinct()
                               .sorted()
                               .reduce("", (n1, n2) -> n1 + n2);

        //有没有交易员是在米兰工作
        boolean milanBased =
                transactionList.stream()
                               .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));


        //打印在生活在剑桥的交易员的所有交易额
        transactionList.stream()
                       .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                       .map(Transaction::getValue)
                       .forEach(System.out::println);


        //所有交易中,最高的交易额是多少
        Optional<Integer> highestValue =
                transactionList.stream()
                               .map(Transaction::getValue)
                               .reduce(Integer::max);


         //用指令风格对交易按照货币分组
//        Map<Currency, List<Transaction>> ttransactionsByCurrencies =
//                transactionList.stream().collect(groupingBy)

    }
}
