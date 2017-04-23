package leetcode;

/**
 * Created by rarshion on 16/8/21.
 */
public class MaximumProductofWordLengths {

    public static int maxProduct(String[] words) {

        if(words.length <= 1)
            return 0;

        int[] mask = new int[words.length];

        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                mask[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }

        int max = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i+1; j < words.length; j++){
                if((mask[i]& mask[j]) == 0){
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }

    public static void main(String[] args){
        String[] test = new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        System.out.println(maxProduct(test));
    }
}
