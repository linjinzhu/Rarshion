package leetcode;

import java.util.HashMap;

/**
 * Author ： Martin
 * Date : 17/4/8
 * Description :
 * Version : 2.0
 */
public class fourSum {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> abMap = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                abMap.put(a + b, abMap.getOrDefault(a + b, 0) + 1);
            }
        }

        int ret = 0;
        HashMap<Integer, Integer> cdMap = new HashMap<>();
        for (int c : C) {
            for (int d : D) {
                int part2 = c + d;
                int part1 = (-part2);
                ret += abMap.getOrDefault(part1, 0);
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        System.out.println(map.getOrDefault(1, 12121212));

    }
}
