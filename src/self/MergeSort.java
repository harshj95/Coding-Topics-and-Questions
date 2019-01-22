package self;

import utils.CommonLib;

public class MergeSort {

    static int arr[] = {7, 3, 8, 5, 6, 4};

    public static void main(String[] args) {

        Mergesort(arr);

        CommonLib.printArray(arr);
    }



    static void Mergesort(int[] arr) {
        Mergesort(arr, new int[arr.length], 0, arr.length - 1);
    }

    static void Mergesort(int[] arr, int[] helper, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;

            Mergesort(arr, helper, p, q);
            Mergesort(arr, helper, q + 1, r);
            Merge(arr, helper, p, q, r);
        }
    }

    static void Merge(int[] arr, int[] helper, int p, int q, int r) {

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
