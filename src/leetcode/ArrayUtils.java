package leetcode;

import java.util.PriorityQueue;

/**
 * Created by rarshion on 16/8/20.
 */
public class  ArrayUtils{

    public static void printArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            int[] elem = matrix[i];
            for(int j = 0; j < elem.length; j++){
                System.out.print(elem[j]);
            }
            System.out.print("\n");
        }
    }

    public static void exchangeElements(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void printQueue(PriorityQueue<Integer> heap){
        PriorityQueue<Integer> temp = new PriorityQueue<>(heap);
        while(!temp.isEmpty()){
            System.out.print(temp.peek().toString() + ' ');
            temp.poll();
        }
    }

    public static void printList(ListNode root){
        while(root != null){
            System.out.print(root.val + " ");
            root = root.next;
        }

        System.out.println();
    }
}