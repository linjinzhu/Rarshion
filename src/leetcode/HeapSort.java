package leetcode;


/**
 * Created by rarshion on 16/8/20.
 */

public class HeapSort {


    public static void heapSort(int[] arrays){
        if(arrays == null || arrays.length == 1)
            return;

        buildHeap(arrays);

        for(int i = arrays.length - 1; i >=0; i--){
            ArrayUtils.exchangeElements(arrays, 0, i);
            //maxHeap(arrays, i, 0);
            minHeap(arrays,i, 0);
        }

    }


    private static void buildHeap(int[] arrays){
        if(arrays == null || arrays.length == 1){
            return;
        }

        int half = arrays.length / 2;
        for(int i = half; i >=0; i--){
           // maxHeap(arrays, arrays.length, i);
            minHeap(arrays, arrays.length, i);
        }
    }

    private static void maxHeap(int[] array, int heapSize, int index){
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        if(left < heapSize && array[left] > array[index]){
            largest = left;
        }

        if(right < heapSize && array[right] > array[largest]){
            largest = right;
        }

        if(index != largest){
            ArrayUtils.exchangeElements(array, index, largest);
            maxHeap(array, heapSize, largest);
        }

    }

    private static void minHeap(int[] array, int heapSize, int index){
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int min = index;
        if(left < heapSize && array[left] < array[index]){
            min = left;
        }

        if(right < heapSize && array[right] < array[min]){
            min = right;
        }

        if(index != min){
            ArrayUtils.exchangeElements(array, index, min);
            maxHeap(array, heapSize, min);
        }
    }

    public static void main(String[] args){
        int[] test = {1,2,4,5,6,3,12,4,3,2,3};
        heapSort(test);
        ArrayUtils.printArray(test);

    }

}
