package Algorithms.Sorting;

public class InsertionSort {

    public static void sort(int[] arr) {
        for (int end = 1; end < arr.length; end++) {
            for (int i = end; i > 0; i--) {
                if (arr[i - 1] > arr[i])
                    swap(arr, i - 1, i);
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
