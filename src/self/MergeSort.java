package self;

import utils.CommonLib;

public class MergeSort {

    private static int arr[] = {7, 11, 8, 7, 5, 3, 6, 4, 1};

    public static void main(String[] args) {

        MergeNew(arr);

        CommonLib.printArray(arr);
    }

    private static void MergeNew(int[] arr) {
        MergesortNew(arr, 0, arr.length - 1);
    }

    private static void MergesortNew(int[] arr, int p, int r) {
        if (p < r) {
            int q = p + (r - p) / 2;

            MergesortNew(arr, p, q);
            MergesortNew(arr, q + 1, r);
            MergeNew(arr, p, q, r);
        }
    }

    private static void MergeNew(int[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];

        if (n1 >= 0) System.arraycopy(arr, p + 0, left, 0, n1);

        for (int i = 0; i < n2; i++) {
            right[i] = arr[q + i + 1];
        }

        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;

        int i = 0, j = 0;

        for (int k = p; k <= r; k++) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
        }
    }


    private static void Mergesort(int[] arr) {
        Mergesort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private static void Mergesort(int[] arr, int[] helper, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;

            Mergesort(arr, helper, p, q);
            Mergesort(arr, helper, q + 1, r);
            Merge(arr, helper, p, q, r);
        }
    }

    private static void Merge(int[] arr, int[] helper, int p, int q, int r) {

        for (int i = p; i <= r; i++) {
            helper[i] = arr[i];
        }

        int helperLeft = p;
        int helperRight = q + 1;
        int current = p;

        while (helperLeft <= q && helperRight <= r) {
            if (helper[helperLeft] <= helper[helperRight]) {
                arr[current] = helper[helperLeft];
                helperLeft++;
            } else {
                arr[current] = helper[helperRight];
                helperRight++;
            }

            current++;
        }

        int remaining = q - helperLeft;

        for (int i = 0; i <= remaining; i++) {
            arr[current + i] = helper[helperLeft + i];
        }
    }
}
