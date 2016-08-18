package leetcode;

/**
 * Created by rarshion on 16/8/12.
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] map = new int[26];

        for(char elem : magazine.toCharArray()){
            map[elem - 'a']++;
        }

        for(char elem : ransomNote.toCharArray()){
            if(map[elem - 'a'] > 0){
                map[elem - 'a']--;
            }else{
                return false;
            }
        }

        return true;

    }


    public static void main(String[] args){

    }
}
