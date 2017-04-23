package ThinkingInJava;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rarshion on 16/9/11.
 */
public class RotateFunction {
    public int maxRotateFunction(int[] A) {

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < A.length; i++){
            queue.add(A[i]);
        }


        for(int i = 0; i < A.length; i++){

            if(!queue.isEmpty() && i != 0) {
                int head = queue.remove();
                queue.add(head);
            }

            Queue<Integer> printTemp = new LinkedList<>(queue);
            while(!printTemp.isEmpty()){
                System.out.print(printTemp.remove());
            }


            System.out.println();
        }
        
        return 0;
    }

    public static void main(String[] args){
        RotateFunction test = new RotateFunction();
        int[] temp = {4,3,2,6};
        test.maxRotateFunction(temp);
    }
}
