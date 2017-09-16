package java8InAction;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Author ： Martin
 * Date : 17/6/20
 * Description :
 * Version : 2.0
 */
public class StreamTest {

    public enum CaloricLevel { DIET, NORMAL, FAT}



    public static long iterativeSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                     .limit(n)
                     .parallel()
                     .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

//        List<String> names = menu.stream().map(Dish::getName).collect(Collectors.toList());
//
//
//        List<String> threeHighCaloricDishNames =
//                menu.stream()
//                .filter(d -> d.getCalories() > 300)
//                .map(Dish::getName)
//                .limit(3)
//                .collect(Collectors.toList());
//
//        System.out.println(threeHighCaloricDishNames);
//
//
//        //用谓词筛选
//        List<Dish> vegetarianDishes =
//                menu.stream()
//                    .filter(Dish::isVegetarian)
//                    .collect(toList());
//
//        //筛选各异的元素
//        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
//        numbers.stream()
//                .filter(i -> i % 2 == 0)
//                .distinct()
//                .forEach(System.out::println);
//
//        //截短流
//        List<Dish> dishes = menu.stream()
//                                .filter(d -> d.getCalories() > 300)
//                                .limit(3)
//                                .collect(toList());
//
//        //跳过元素
//        List<Dish> skipDishes = menu.stream()
//                                .filter(d -> d.getCalories() > 300)
//                                .skip(2)
//                                .collect(toList());
//
//        //
//        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
//        List<Integer> wordLengths = words.stream()
//                                         .map(String::length)
//                                         .collect(toList());
//
//        //检查谓词是否匹配一个元素
//        boolean isFrendly = menu.stream().anyMatch(Dish::isVegetarian);
//
//        //检查谓词是否至少匹配一个元素
//        boolean isHealthy = menu.stream().allMatch(d -> d.getCalories() < 10000);
//
//        //检查谓词是否匹配所有元素
//        boolean isHealthyToo = menu.stream().noneMatch(d -> d.getCalories() >= 10000);
//
//        //查找第一个元素
//        List<Integer> someNumber = Arrays.asList(1, 2, 3, 4, 5);
//        Optional<Integer> firstSquareDivisibleByThree =
//                someNumber.stream()
//                          .map(x -> x*x)
//                          .filter(x -> x%3 == 0)
//                          .findFirst();


        //规约:数组求和
        List<Integer> reduceNumbers = Arrays.asList(4, 5, 6, 7, 8);
        int sum = reduceNumbers.stream().reduce(0, (a, b) -> a + b);

        //规约:求数组最大值
        Optional<Integer> max = reduceNumbers.stream().max(Integer::max);






//        //数值创建流
//        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
//        stream.map(String::toUpperCase).forEach(System.out::println);
//
//        //由数组创建流
//        int [] streamFromArray  = {2, 3, 5, 7, 11, 13};
//        int sum = Arrays.stream(numbers).sum();
//
//
//        //由文件生成流
//        long uniqueWords = 0;
//        try (Stream<String> lines =
//                     Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
//            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
//                               .distinct()
//                               .count();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        


//        String[] arrayOfWords = {"Goodbye", "World"};
//        Stream<String> stringOfWords = Arrays.stream(arrayOfWords);
//        stringOfWords.map(word->word.split(""))
//                    .flatMap(Arrays::stream)
//                    .distinct()
//                    .collect(Collectors.toList());
//
//
//        Comparator<Dish> dishCaloriesComparator =
//                Comparator.comparingInt(Dish::getCalories);

//        Optional<Dish> mostCalorieDish =
//                menu.stream()
//                    .map(Dish::getName)
//                    .collect(joinning());


//        int totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
//

        //分组
        Map<Dish.Type, List<Dish>> dishedByType = menu.stream().collect(groupingBy(Dish::getType));
//        System.out.println(dishedByType.toString());
//
//        Map<CaloricLevel, List<Dish>> dishedByType1 = menu.stream().collect(
//                groupingBy(dish -> {
//                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
//                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
//                    else return CaloricLevel.FAT;
//                }));
//        System.out.println(dishedByType1.toString());
//
//        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishedByTypeCaloricLevel =
//                menu.stream().collect(
//                        groupingBy(Dish::getType,
//                                groupingBy(dish -> {
//                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
//                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
//                                    else return CaloricLevel.FAT;
//                                }))
//                );
//        System.out.println(dishedByTypeCaloricLevel.toString());


//        List<Dish> vegetarianDishes =
//                menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
//
//        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType =
//                menu.stream().collect(
//                        partitioningBy(Dish::isVegetarian,
//                                groupingBy(Dish::getType))
//                );
//        System.out.println(vegetarianDishesByType.toString());


//        System.out.println(System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism"));
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");
//        System.out.println(iterativeSum(50));



//        List<Dish> lowCaloricDishes = new ArrayList<>();
//
//        //用累加器筛选元素
//        for (Dish d : menu) {
//            if (d.getCalories() < 400) {
//                lowCaloricDishes.add(d);
//            }
//        }
//
//        //用匿名类对菜肴排序
//        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
//            @Override
//            public int compare(Dish o1, Dish o2) {
//                return Integer.compare(o1.getCalories(), o2.getCalories());
//            }
//        });
//
//
//        //处理排序后菜名列表
//        List<String> lowCaloricDishesName = new ArrayList<>();
//        for (Dish d : lowCaloricDishes) {
//            lowCaloricDishes.add(d.getName());
//        }
//

         List<String> lowCaloricDishesName =
                 menu.stream()
                     .filter(d -> d.getCalories() < 400)                //选出400卡路里以下的菜肴
                     .sorted(Comparator.comparing(Dish::getCalories))   //按照卡路里排序
                     .map(Dish::getName)                                //提取菜肴名字
                     .collect(toList());                                //将所有名称保存在List中



        List<String> threeHighCaloricDishNames =
                menu.stream()                               //从menu获得流(菜肴列表)
                        .filter(d ->
                        {
                            System.out.println("filter" + d.getName());
                            return d.getCalories() > 300;
                        })                                      //建立操作流水线:首先选出高热量的菜肴
                        .map(d ->
                        {
                            System.out.println("mapping" + d.getName());
                            return d.getName();
                        })                                      //获取名字
                        .limit(3)                               //只选择头三个
                        .collect(toList());                     //将结果保存在另一个List中

        //第六章归约与汇总
        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);

        //查找流中的最大值
        Optional<Dish> mostCalorieDIsh = menu.stream()
                                             .collect(maxBy(dishCaloriesComparator));

        //汇总
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));

        //平均数
        double averageCalories = menu.stream().collect(averagingInt(Dish::getCalories));

        //
         String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));

        //卡路里总和
//        int totaldCalories = menu.stream().collect(reducing(0, Dish::getCalories, (i ,j ) -> i + j));
        int totaldCalories = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));



        //集合:用for-each循环外部迭代
        List<String> names = new ArrayList<>();
        for (Dish d : menu) {
            names.add(d.getName());
        }

        //集合:用背后的迭代器做外部迭代
        List<String> names_t = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Dish d = iterator.next();
            names_t.add(d.getName());
        }

        //流:使用内部迭代
        List<String> names_s = menu.stream().map(Dish::getName).collect(toList());

    }


}
