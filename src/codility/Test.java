package codility;

public class Test {

    private static int[] arr = {6, 1, 4, 6, 3, 2, 7, 4};

    public static void main(String[] args) {
        System.out.println(solution(arr, 3, 2));
    }

    public static int solution(int[] A, int K, int L) {
        if (K + L > A.length) {
            return -1;
        } else if (K + L == A.length) {
            int i = 0;
            int sum = 0;
            for (i = 0; i < K; i++) {
                sum += A[i];
            }

            int j = i + 1;

            for (j = i + 1; j < i + L + 1; j++) {
                sum += A[j];
            }

            return sum;
        } else {
            int sum = 0;

            sum += calculateMaxConsecutiveTrees(A, K);
            sum += calculateMaxConsecutiveTrees(A, L);

            return sum;
        }
    }

    private static int calculateMaxConsecutiveTrees(int[] arr, int size) {
        int start = 0;
        int currentSum;

        int result = 0;

        for (int i = 0; i < size; i++) {
            result += arr[i];
        }

        currentSum = result;

        for (int i = size; i < arr.length; i++) {
            currentSum += arr[i] - arr[i - size];

            if (currentSum > result) {
                result = currentSum;
                start = i;
            }
        }

        removeAddedElements(arr, start, start + size - 1);

        return result;
    }

    private static void removeAddedElements(int[] arr, int start, int end) {
        for (int i = start; i < end - start + 1; i++) {
            arr[i] = 0;
        }
    }
}
