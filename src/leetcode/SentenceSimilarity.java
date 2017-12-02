package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author ： Martin
 * Date : 17/12/1
 * Description :
 * Version : 2.0
 */
public class SentenceSimilarity {

    public static boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length)
            return false;

        Map<String, Set<String>> pairMap = new HashMap<>();
        for (String[] pair : pairs) {
            Set<String> set1 = pairMap.getOrDefault(pair[0], new HashSet<>());
            set1.add(pair[1]);
            pairMap.put(pair[0], set1);
            Set<String> set2 = pairMap.getOrDefault(pair[1], new HashSet<>());
            set2.add(pair[0]);
            pairMap.put(pair[1], set2);
        }

        Set<String> word1Set = new HashSet<>();
        Collections.addAll(word1Set, words1);

        Set<String> word2Set = new HashSet<>();
        Collections.addAll(word2Set, words2);

        for (int i = 0; i < words1.length; i++) {
            Set<String> value = pairMap.getOrDefault(words1[i], new HashSet<>());
            if (!words1[i].equals(words2[i]) && !word2Set.containsAll(value)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] str1 = {"an","extraordinary","meal"};
        String[] str2 = {"one","good","dinner"};
        String[][] str3 = { {"great","fine"}, {"drama","acting"},{"skills","talent"}};
        System.out.println(areSentencesSimilar(str1, str2, str3));

//        Set<String> set1 = new HashSet<>();
//        set1.add("hello");
//        set1.add("hi");
//        Set<String> set2 = new HashSet<>();
//        set2.add("hi");
//        System.out.println(set1.containsAll(set2));
    }
}
