package leetcode;

import java.util.*;

/**
 * Author ： Martin
 * Date : 17/9/13
 * Description :
 * Version : 2.0
 */
public class Permutation {

    public static void main(String[] args) {
        String temp = "abcdef";
        List<String> src = allPermutation(temp);
        List<String> result = remove(src);
        System.out.print(Arrays.deepToString(result.toArray()));
    }

    private static List<String> remove(List<String> temp) {
        Iterator<String> iterator = temp.iterator();
        while(iterator.hasNext()) {
            String value = iterator.next();
            if (value.contains("ce") || value.contains("ec") ||value.charAt(2) == 'c') {
                iterator.remove();
            }
        }
        return temp;
    }

    private static List<String> allPermutation(String str){
        if(str == null || str.length() == 0) {
            return Collections.emptyList();
        }
        List<String> result = new LinkedList<>();
        allPermutation(str.toCharArray(), result, 0);
        return result;
    }

    private static void allPermutation(char[] c, List<String> listStr, int start){
        if(start == c.length-1) {
            listStr.add(String.valueOf(c));
        } else {
            for(int i = start; i <= c.length-1; i++) {
                swap(c, i, start);
                allPermutation(c, listStr, start+1);
                swap(c, start, i);
            }
        }
    }

    private static void swap(char[] c, int i, int j){
        char tmp;
        tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }


}
