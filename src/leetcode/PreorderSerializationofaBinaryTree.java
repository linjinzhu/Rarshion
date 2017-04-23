package leetcode;

import java.util.Stack;

/**
 * Created by rarshion on 16/10/5.
 */
public class PreorderSerializationofaBinaryTree {

    public static boolean isValidSerialization(String preorder) {

        String[] strings = preorder.split(",");
        if (strings.length == 0) return true;
        int hole = 0;

        if (!strings[0].equals("#")) hole += 2;

        for (int i = 1; i < strings.length; i++) {
            if (!strings[i].equals("#")) {
                if (hole > 0) {
                    hole++;
                } else {
                    return false;
                }
            } else {
                hole--;
            }

            if (hole < 0) return false;
        }

        return hole == 0 ? true : false;
    }

    public static void main(String[] args) {
        isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }

}
