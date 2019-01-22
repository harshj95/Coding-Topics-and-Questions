package self;

import utils.CommonLib;

public class QuickSort {

    private static int arr[] = {7, 6, 5, 4, 1, 2};

    public static void main(String[] args) {

        sort(arr, 0, arr.length - 1);

        CommonLib.printArray(arr);
    }

    private static void sort(int[] arr, int p, int r) {
        if (p < r) {
            int pivot = partition(arr, p, r);
            sort(arr, p, pivot - 1);
            sort(arr, pivot + 1, r);
        }
    }

    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];

        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (arr[j] < pivot) {
                i = i + 1;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i = i + 1;
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
        return i;
    }
}
