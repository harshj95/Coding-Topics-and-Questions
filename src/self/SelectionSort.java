package self;

import utils.CommonLib;

public class SelectionSort {

    public static void main(String[] args) {
        int a[] = {4, 7, 1, 2, 3, 10, 8};

        for (int i = 0; i < a.length; i++) {
            int min = i;

            for (int j = i; j < a.length; j++) {
                if(a[min]>a[j]) {
                    min = j;
                }
            }

            if (min!=i) {
                int temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }

        CommonLib.printArray(a);
    }
}
