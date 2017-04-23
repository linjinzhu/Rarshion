package mianshi;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author ： Martin
 * Date : 17/3/30
 * Description :
 * Version : 2.0
 */
public class QuickSort {

    public static void swap(int[] src, int i, int j) {
        int temp = src[i];
        src[i] = src[j];
        src[j] = temp;
    }

    public static void selectSort(int[] src) {
        for (int i = 0; i < src.length; i++) {
            for (int j = i + 1; j < src.length; j++) {
                if (src[i] > src[j]) {
                    swap(src, i, j);
                }
            }
        }
    }

    public static void insertSort(int[] src) {
        for (int i = 1; i < src.length; i++) {
            for (int j = i; (j > 0) && (src[j - 1] > src[j]); j--) {
                swap(src, j, j - 1);
            }
        }
    }

    public static void shellSort(int[] src) {
        int len = src.length;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                for (int j = i - gap; j >= 0 && src[j] > src[j + gap]; j -= gap) {
                    swap(src, j, j + gap);

                }
            }
        }
    }

    public static void printArray(int[] src) {
        for (int i = 0; i < src.length; i++) {
            System.out.print(" " + src[i]);
        }
    }

    public static int sortHelper(int[] src, int left, int right) {
        int temp = src[left];
        while (left < right) {
            while (left < right && src[right] >= temp) {
                right--;
            }
            src[right] = src[left];
            while (left < right && src[left] <= temp) {
                left++;
            }
            src[left] = src[right];
        }
        src[left] = temp;
        return left;
    }

    public static void quickSort(int[] src, int left, int right) {
        if (left < right) {
            int pivot = sortHelper(src, left, right);
            quickSort(src, left, pivot - 1);
            quickSort(src, pivot + 1, right);
        }
    }

    public static int binarySearch(int[] src, int left, int right, int key) {
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (src[mid] < key) {
                left = mid + 1;
            } else if (src[mid] >key) {
                right = mid - 1;
            } else {
                return src[mid];
            }
        }
        return -1;
    }


    public static void stringSort(String strs[]) {
        for (int i = 1; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length - 1; j++) {
                if (StringCmp(strs[j + 1], strs[j])) {
                    String temp = strs[j + 1];
                    strs[j + 1] = strs[j];
                    strs[j] = temp;
                }
            }
        }
    }



    public static boolean StringCmp(String str1, String str2) {
        return false;
    }


    public static void main(String[] args) {
        int[] src = {3, 2, 1, 4};
//        quickSort(src, 0, src.length - 1);
//        System.out.println(src);
//        System.out.println(binarySearch(src, 0, src.length - 1, 2));
//        insertSort(src);
//        shellSort(src);
//        printArray(src);

        String i = "";
        System.out.println(i + 0);
        if (i == i + 0) {
            System.out.println("hello world");
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                int result = i % 2 - j % 2;
                if (result == 0) {
                    result = i - j;
                }
                return result;
            }
        });



    }
}
