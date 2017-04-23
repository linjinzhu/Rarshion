package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by rarshion on 16/8/20.
 */
public class KthSmallestElementinaSortedMatrix{

        public static int kthSmallest(int[][] matrix, int k) {

            PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(o1 > o2)
                        return -1;
                    else if(o1 < o2)
                        return 1;
                    return 0;
                }
            });

            for(int i = 0; i < matrix.length; i++){
               for(int j = 0; j < matrix[i].length; j++){
                   maxHeap.add(matrix[i][j]);
                   if(maxHeap.size() > k)
                       maxHeap.poll();
               }
                ArrayUtils.printQueue(maxHeap);
                System.out.print('\n');
            }

            return maxHeap.peek();
        }

        public static void main(String[] args){

            int[][] test = {{1,5,9}, {10,11,13}, {12,13,15}};
            System.out.println(kthSmallest(test, 4));
            //ArrayUtils.printMatrix(test);
/*
            PriorityQueue<Integer> testHeap = new PriorityQueue<>();
            testHeap.add(5);
            testHeap.add(3);
            testHeap.add(1);
            testHeap.add(2);
            ArrayUtils.printQueue(testHeap);
*/

        }
}
