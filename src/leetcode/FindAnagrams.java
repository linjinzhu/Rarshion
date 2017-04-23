package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author ： Martin
 * Date : 17/4/9
 * Description :
 * Version : 2.0
 */
public class FindAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
//        List<Integer> result = new ArrayList<>();
//        HashMap<Character, Integer> chMap = new HashMap<>();
//        for (int i = 0; i < p.length(); i++) {
//            Character ch = p.charAt(i);
//            chMap.put(ch, chMap.getOrDefault(ch, 0) + 1);
//        }
//
//        for (int i = 0; i < s.length() - p.length() + 1; i++) {
//            String sub = s.substring(i, i + p.length());
//            HashMap<Character, Integer> chCMap = new HashMap<>();
//            for (int j = 0; j < sub.length(); j++) {
//                Character ch = sub.charAt(j);
//                chCMap.put(ch, chCMap.getOrDefault(ch, 0) + 1);
//            }
//            if (chMap.equals(chCMap)) result.add(i);
//        }


        List<Integer> result = new ArrayList<>();
        int NumberOfDeference = p.length();
        int left=0, right=0;
        int[] asciiChars = new int[256];
        for (int i = p.length() - 1; i>=0; --i)
            ++asciiChars[p.charAt(i)];

        for(; right<s.length(); right++) {

            asciiChars[s.charAt(right)]--;
            if(asciiChars[s.charAt(right)] >= 0)
                NumberOfDeference--;

            if(right-left == (p.length()-1)) {
                if(NumberOfDeference==0) result.add(left);
                if(asciiChars[s.charAt(left)] >= 0) {
                    NumberOfDeference++;
                }
                asciiChars[s.charAt(left)]++;
                left++;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        List<Integer> result = findAnagrams("cbaebabacd", "abc");
        System.out.println(result.toString());
    }


}
