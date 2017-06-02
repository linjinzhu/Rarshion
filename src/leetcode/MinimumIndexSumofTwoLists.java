package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Author ： Martin
 * Date : 17/5/29
 * Description :
 * Version : 2.0
 */
public class MinimumIndexSumofTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> strToIndex = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            strToIndex.put(list1[i], i);
        }

        String restaurantName;
        int minCommon = Integer.MAX_VALUE;
        Map<Integer, LinkedList<String>> commonInterests = new HashMap<>();

        for (int i = 0; i < list2.length; i++) {
            if (strToIndex.containsKey(list2[i])) {
                if (strToIndex.get(list2[i]) + i <= minCommon) {
                    minCommon = strToIndex.get(list2[i]) + i;
                    restaurantName = list2[i];
                    LinkedList<String> list = commonInterests.get(minCommon);
                    if (list == null) {
                        list = new LinkedList<>();
                    }
                    list.add(restaurantName);
                    commonInterests.put(minCommon, list);
                }
            }
        }

        List<String> list = commonInterests.get(minCommon);
        return list.toArray(new String[list.size()]);
    }
}
