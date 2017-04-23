package leetcode;

/**
 * Created by rarshion on 16/8/31.
 */
public class Test {

    public static void main(String[] args){
        LRUCache cache = new LRUCache(3);
        cache.set(3,3);
        cache.set(4,5);
        cache.set(5,4);

        System.out.println(cache.toString());
    }

}


