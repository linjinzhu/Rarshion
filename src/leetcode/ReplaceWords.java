package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Author ： Martin
 * Date : 17/8/28
 * Description :
 * Version : 2.0
 */
public class ReplaceWords {

    public static String replaceWords(List<String> dict, String sentence) {

        String[] words =  sentence.split(" ");
        int wordsLen = words.length;
        int[] maps = new int[wordsLen];

        for (String elem : dict) {
            int len = elem.length();
            for (int i = 0; i < wordsLen; i++) {
                if (maps[i] != 1 && Objects.equals(words[i].substring(0, len > words[i].length() ? words[i].length() : len), elem)) {
                    maps[i] = 1;
                    words[i] = elem;
                }
            }
        }

        StringBuilder dst = new StringBuilder();
        for (int i = 0; i < wordsLen - 1; i++) {
            dst.append(words[i]).append(" ");
        }
        dst.append(words[wordsLen - 1]);
        return dst.toString();
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dict, sentence));
    }
}
