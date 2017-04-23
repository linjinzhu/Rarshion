package leetcode;

/**
 * Created by rarshion on 16/10/9.
 */
public class SuperUglyNumber {

    public static int findMin(int[] nums){
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = min > nums[i] ? nums[i] : min;
        }
        return min;
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        int size = primes.length;
        int q[] = new int[n];
        int idex[] = new int[size];
        int vals[] = new int[size];

        q[0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < size; j++) {
                vals[j] = q[idex[j]] * primes[j];
            }

            q[i] = findMin(vals);

            for (int j = 0; j < size; j++) {
                if (q[i] == vals[j]) {
                    idex[j] += 1;
                }
            }
        }

        return q[n-1];
    }

    public static void main(String[] args) {
        int temp[] = new int[]{2,7,13,19};
        int i = nthSuperUglyNumber(12, temp);
    }
}
