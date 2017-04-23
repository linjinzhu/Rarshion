package ThinkingInJava;

import java.util.*;

/**
 * Created by rarshion on 16/9/26.
 */
public class TestList {

    public static void main(String[] args) {
        List<String> tList1 = new ArrayList<>();
        tList1.add("s1");
        tList1.add("s2");
        tList1.add("s3");
        tList1.add("s4");
        tList1.add("s5");
        tList1.add("s6");

        List<String> tList2 = new ArrayList<>();
        tList2.add("s3");
        tList2.add("s4");
        tList2.add("s5");
        tList2.add("s7");


        //tList1.removeAll(tList2);

        List<String> diff = new LinkedList<>(getDifferent2(tList1,tList2));
        for(int i = 0; i < diff.size(); i++) {
            System.out.println(diff.get(i));
        }


    }

    private static List<String> getDifferent1(List<String> list1, List<String> list2) {
        List<String> diff = new ArrayList<>();
        List<String> maxList = list1;
        List<String> minList = list2;

        if(list2.size() > list1.size()) {
            maxList = list2;
            minList = list1;
        }


        Map<String, Integer> maxMap = new HashMap<>(maxList.size());
        for(String elem : maxList) {
            maxMap.put(elem, 1);
        }

        for(String elem : minList) {
            if (maxMap.containsKey(elem)) {
                maxMap.put(elem, 2);
                continue;
            }
            diff.add(elem);
        }

        for (Map.Entry<String, Integer> entry : maxMap.entrySet()) {
            if (entry.getValue() == 1) {
                diff.add(entry.getKey());
            }
        }

        return diff;
    }



    private static Collection getDifferent2(Collection collectmax, Collection collectmin) {

        Collection resultList = new LinkedList<>();
        Collection maxCollection = collectmax;
        Collection minCollection = collectmin;

        if (collectmax.size()<collectmin.size()) {
             maxCollection = collectmin;
             minCollection = collectmax;
        }

        Map<Object,Integer> map = new HashMap<>(maxCollection.size());
        for (Object object : maxCollection) {
             map.put(object, 1);
        }

        for (Object object : minCollection) {
            if (!map.containsKey(object)) {//不存在则增加
                resultList.add(object);
            } else { //已存在则更新
                map.put(object, 2);
            }
        }

        for (Map.Entry<Object, Integer> entry : map.entrySet()) {
            if (entry.getValue()==1) {
                resultList.add(entry.getKey());
            }
        }

        return resultList;
    }

}
