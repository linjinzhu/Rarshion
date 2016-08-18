package leetcode;

import java.util.*;

/**
 * Created by rarshion on 16/8/16.
 */
public class TopKFrequentElements {

    public class Elem implements Comparable<Elem>  {

        int value, fre;

        public Elem(int value, int fre){
            this.value = value;
            this.fre = fre;
        }

        public int compareTo(Elem other){
            if(this.fre > other.fre){
                return 1;
            }else if(this.fre < other.fre){
                return -1;
            }else{
                return 0;
            }
        }
    }


    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> ret = new ArrayList<Integer>();
        Map<Integer, Elem> maps = new HashMap<Integer, Elem>();

        for(int i : nums){
            Elem elem;
            if(maps.containsKey(i)){
                 elem = maps.get(i);
                 elem.fre++;
            }else{
                elem = new Elem(i, 1);
            }
            maps.put(i, elem);
        }

        List<Elem> values = new ArrayList<>();
        Set<Integer> keys = maps.keySet();

        for(Integer key:keys){
            values.add(maps.get(key));
        }

        Collections.sort(values);

        for(int i = 0; i < k; i++){
            Elem elem = values.get(values.size() - 1 - i);
            ret.add(elem.value);
        }

        return ret;
    }
}
