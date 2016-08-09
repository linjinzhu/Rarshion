package leetcode;

/**
 * Created by user on 2016/8/2.
 */
public class reverseString {

    public String reverseString(String s){
        if(s == null || s.length() == 0)
            return s;

        int index = 0;
        char[] temp = new char[s.length()];
        for(int i = s.length() - 1; i >= 0; i--){
            temp[index++] = s.charAt(i);
        }

        return new String(temp);
    }


    public static void main(String[] args){
        reverseString rs = new reverseString();
        System.out.println(rs.reverseString("hello"));
    }
}
