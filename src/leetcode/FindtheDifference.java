package leetcode;

/**
 * Created by rarshion on 16/10/27.
 */
public class FindtheDifference {

    public static char findTheDifference(String s, String t) {

        /*
        Map<Character, Integer> srcMap = new HashMap<>();

       for (int i = 0; i < s.length(); i++) {
           char ch = s.charAt(i);
           if (srcMap.get(ch) != null) {
               int count = srcMap.get(ch);
               srcMap.put(ch, count++);
           } else {
               srcMap.put(ch, 1);
           }
       }

       for (int i = 0; i < t.length(); i++) {
           char ch = t.charAt(i);
           if (srcMap.get(ch) != null) {
               int count = srcMap.get(ch);
               if (count-- <= 0)
                   return ch;
               srcMap.put(ch, count);
           } else {
               return ch;
           }
       }

       return 'c';

       */


        char temp = 0;

        for (int i = 0; i < s.length(); i++) {
            temp = (char) (temp ^ s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            temp = (char) (temp ^ t.charAt(i));
        }

        return temp;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("a", "aa"));
    }

}
