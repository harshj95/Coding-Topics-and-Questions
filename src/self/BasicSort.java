package self;

import utils.CommonLib;

public class BasicSort {

    public static void main(String[] args) {
        int array[] = {4, 7, 1, 2, 3, 10, 8};

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        CommonLib.printArray(array);
    }

}
