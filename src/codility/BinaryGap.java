package codility;

import java.util.Scanner;

public class BinaryGap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int res = binaryGap(N);

        System.out.println(res);

    }

    private static int binaryGap(int N) {
        int n = N;
        int i = 0;
        int[] digits = new int[32];
        int validDigits = 0;

        for (int j = 0; j < 32; j++) {
            digits[j] = -1;
        }

        while (n != 0) {
            digits[i] = n % 2;
            i++;
            n = n / 2;
            validDigits++;
        }

        int j = 0;
        int count = 0;
        int max = 0;
        while (j < validDigits) {
            if (digits[j] == 1) {
                if (j == validDigits - 1) {
                    return max;
                }
                j += 1;
                count = 0;
                while (digits[j] == 0) {
                    count++;
                    j++;
                }
                if (digits[j] == 1) {
                    if (count > max) {
                        max = count;
                        j--;
                    }
                }
            }
            j++;
        }

        return max;
    }
}
