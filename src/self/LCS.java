package self;

import java.util.Arrays;

public class LCS {

    static String first = "bbbb";
    static String second = "ccccc";

    static int arr[][] = new int[4][5];

    public static void main(String[] args) {
        for (int i=0;i<4;i++) {
            for (int j=0;j<5;j++) {
                arr[i][j] = -1;
            }
        }

        System.out.println(dpLCS(first.toCharArray(), second.toCharArray(), 4, 5));
    }

    static int recurseLCS(char[] P, char[] Q, int n, int m) {
        if (m == 0 || n == 0) {
            return 0;
        } else if (P[n - 1] == Q[m - 1]) {
            return 1 + recurseLCS(P, Q, n - 1, m - 1);
        } else {
            return Math.max(recurseLCS(P, Q, n - 1, m), recurseLCS(P, Q, n, m - 1));
        }
    }

    static int dpLCS(char[] P, char[] Q, int n, int m) {
        int result;

        if (arr[n-1][m-1]!=-1)
            return arr[n-1][m-1];
        if (m == 0 || n == 0) {
            result = 0;
        } else if (P[n - 1] == Q[m - 1]) {
            result = 1 + recurseLCS(P, Q, n - 1, m - 1);
        } else {
            result = Math.max(recurseLCS(P, Q, n - 1, m), recurseLCS(P, Q, n, m - 1));
        }

        arr[n-1][m-1] = result;

        return result;
    }


}
