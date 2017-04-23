package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rarshion on 16/9/13.
 */
public class WordDictionary {

    public TrieNode root = new TrieNode();

    class TrieNode{
        public boolean isEnd;
        char c;
        HashMap<Character, TrieNode> children = new HashMap<>();

        public TrieNode(char c){
            this.isEnd = false;
            this.c = c;
        }

        public TrieNode(){

        }
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        Map<Character, TrieNode> children = root.children;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            TrieNode temp;
            if(children.containsKey(c)){
                temp = children.get(c);
            }else{
                temp = new TrieNode(c);
                children.put(c, temp);
            }

            children = temp.children;
            if(i == word.length() - 1)
                temp.isEnd = true;
        }
    }

    public boolean search(String word) {
        return search(word, root);
    }


    public boolean search(String word, TrieNode node){
        if(node == null) return false;
        if(word.length() == 0) return node.isEnd;

        Map<Character, TrieNode> children = node.children;
        TrieNode t = null;
        char c = word.charAt(0);

        if(c == '.'){// .为广度搜索
            for(char key : children.keySet()){
                if(search(word.substring(1), children.get(key)))
                    return true;
            }
            return false;
        }else if(!children.containsKey(c)){ //字符不匹配直接返回false
            return false;
        }else{ //相等进行深度搜索
            t = children.get(c);
            return search(word.substring(1), t);
        }
    }

    public WordDictionary(){
        this.root = new TrieNode();
    }

    public static void main(String[] args){
        WordDictionary dic = new WordDictionary();
        dic.addWord("abb");
        System.out.println(dic.search(".ab"));

    }
}
