package yanmoshejimoshi;

/**
 * Author ： Martin
 * Date : 17/3/21
 * Description :
 * Version : 2.0
 */
public class Sort {
    public static void bubleSort(int[] src) {
        for (int i = 0; i < src.length - 1; i++) {
            for (int j = i + 1; j < src.length - 1; j++) {
                if (src[j] > src[j+1]) {
                    int temp = src[j];
                    src[j] = src[j + 1];
                    src[j + 1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] src) {
        for (int i = 0; i < src.length; i++) {
            System.out.println(src[i]);
        }
    }

    public static void main(String[] args) {
        int[] temp = {1, 3, 2, 5, 3};
    }
}
