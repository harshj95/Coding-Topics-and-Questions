package self;

import java.util.PriorityQueue;

public class KthLargest {

    private static int[] arr = new int[] {1, 2, 3, 4 ,5 ,6};

    public static void main(String[] args) {
        System.out.println(kthLargest(arr, 3));
    }

    private static int kthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i : arr) {
            minHeap.add(i);

            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }

        return minHeap.remove();
    }
}
