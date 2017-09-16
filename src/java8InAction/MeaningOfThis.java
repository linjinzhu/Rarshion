package java8InAction;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * Author ： Martin
 * Date : 17/6/8
 * Description :
 * Version : 2.0
 */
public class MeaningOfThis {
    public final int value = 4;
    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;
            @Override
            public void run() {
                int value = 10;
                System.out.println(value);
            }
        };
        r.run();
    }

    public static void main(String[] args) {
//        MeaningOfThis m = new MeaningOfThis();
//        m.doIt();
//
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream().map(n->n*n).collect(toList());


        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1.stream()
                                    .flatMap(i ->
                                                numbers2.stream()
                                                        .filter(j -> (i + j) % 3 == 0)
                                                        .map(j -> new int[] { i, j})
                                    )
                                    .collect(toList());

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByTree =
              someNumbers.stream()
                         .map(x -> x * x)
                         .filter(x -> x % 3 == 0)
                         .findFirst();

        int sum = someNumbers.parallelStream().reduce(0, (a,b)->a+b);
        int product = someNumbers.stream().reduce(0, (a,b)->a*b);
        long count = someNumbers.stream().count();




    }
}
