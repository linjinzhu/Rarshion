package leetcode;

import java.util.*;

/**
 * Created by rarshion on 16/8/15.
 */
public class ShuffleNew {

    RandomizedSet set;
    int nums[];

    public ShuffleNew(int[] nums) {
        set = new RandomizedSet();
        this.nums = nums;
        for(int i = 0; i < nums.length; i++){
            set.insert(nums[i]);
        }
    }

    public int[] reset() {
        set = new RandomizedSet();
        for(int i = 0; i < this.nums.length; i++){
            set.insert(this.nums[i]);
        }
        return nums;
    }

    public int[] shuffle() {
        RandomizedSet temp = new RandomizedSet();
        int[] res = new int[set.list.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = set.getRandom();
            set.remove(res[i]);
            temp.insert(res[i]);
        }
        this.set = temp;
        return res;
    }

    class RandomizedSet {

        public List<Integer> list = new ArrayList<Integer>();
        public Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Random r = new Random();

        public int getRandom(){
            return list.get(r.nextInt(list.size()));
        }

        public RandomizedSet(){
        }

        public boolean insert(int m){
            if(map.containsKey(m)){
                return false;
            }else{
                list.add(m);
                map.put(m,map.size());
                return true;
            }
        }

        public boolean remove(int m){
            if(!map.containsKey(m)){
                return false;
            }else{
                int idx = map.remove(m);
                if(idx < list.size() - 1){
                    list.set(idx, list.get(list.size() - 1));
                    map.put(list.get(list.size() - 1), idx);
                }
                list.remove(list.size() - 1);
                return true;
            }
        }
    }

    public static void main(String[] args){

        int[] temp = new int[]{1,2,3,4,5,6,7,8};
        ShuffleNew  s = new ShuffleNew(temp);
        int[] test = s.shuffle();

        for(int i = 0; i <test.length; i++){
            System.out.println(test[i]);
        }
    }

}
