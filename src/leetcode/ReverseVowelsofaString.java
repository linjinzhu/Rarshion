package leetcode;

/**
 * Created by rarshion on 16/8/11.
 */
public class ReverseVowelsofaString {

    private static boolean  isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            return true;
        else
            return false;

    }


    public static String reverseVowels(String s) {

        int left = 0, right = s.length() - 1;
        char[] temp = s.toCharArray();

        while(left < right){
            if(isVowel(temp[left]) && isVowel(temp[right])){
                char t = temp[left];
                temp[left] = temp[right];
                temp[right] = t;
                left++;
                right--;
            }else if(isVowel(temp[left])){
                right--;
            }else{
                left++;
            }
        }

        s = new String(temp);

        return s;
    }

    public static void main(String[] args){



        System.out.println(reverseVowels("hello"));
    }
}
