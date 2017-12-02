package suanfa;

/**
 * Author ： Martin
 * Date : 17/9/26
 * Description :
 * Version : 2.0
 */
public class Chapter2 {
    public static void sort(Comparable[] a) {

    }

    public static void selectSort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
                exch(a, i, min);
            }
        }
    }

    public static void insertSort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
        }
    }

    public static void shellSort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3)  h = 3 * h + 1;
        while (h >= 1) {
            for (int i  = h; i < N; i++) {
                for (int j = i; i > h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static double time(String alg, Comparable[] a) {
        StopWatch watch = new StopWatch();
        if (alg.equals("insert")) insertSort(a);
        if (alg.equals("select")) selectSort(a);
        watch.end();
        return watch.getElapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
            }
        }
        return 0.0f;
    }


    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length;i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void merge(Comparable[] a, int low, int mid, int high) {

        Comparable[] aux = new Comparable[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (less(a[i], a[j])) {
                aux[k] =  a[i];
                i++;
                k++;
            } else {
                aux[k] = a[j];
                j++;
                k++;
            }
        }

        while(i <= mid) {
            aux[k] = a[i];
            i++;
            k++;
        }

        while(j <= high) {
            aux[k] = a[j];
            j++;
            k++;
        }

        for (k = 0, i = low; i <= high; i++, k++) {
            a[i] = aux[k];
        }

    }

    private static void mergeSort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);
        merge(a, low, mid, high);
    }


    private static void quickMerge(Comparable[] a,int low, int high) {
        if (high <= low) return;
        int j = quickSort(a, low, high);
        quickSort(a, low, j);
        quickSort(a, j + 1, high);
    }

    private static int quickSort(Comparable[] a, int low, int high) {
        int i = low, j = high + 1;
        Comparable k = a[low];
        while (true) {
            while (less(a[++i], k)) if (i == high) break;
            while (less(k, a[--j])) if (j == low) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, low, j);
        return j;
    }

    private void swim(Comparable[] a, int k) {
        while (k > 1 && less(a[k/2], a[k])) {
            exch(a, k/2, k);
            k = k / 2;
        }
    }

    private void sink(Comparable[] a, int k) {
        while (2 * k <= a.length) {
            int j = 2 * k;
            if (j < a.length && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            k = j;
        }
    }



    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
