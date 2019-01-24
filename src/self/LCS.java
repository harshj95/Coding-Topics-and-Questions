package self;

public class LCS {

    static String first = "bbbb";
    static String second = "ccbbcc";

    static int arr[][] = new int[first.length() + 1][second.length() + 1];

    public static void main(String[] args) {
        for (int i = 0; i < first.length() + 1; i++) {
            for (int j = 0; j < second.length() + 1; j++) {
                arr[i][j] = -1;
            }
        }

        System.out.println(dpLCS(first.toCharArray(), second.toCharArray(), 4, 5));
    }

    private static int recurseLCS(char[] P, char[] Q, int n, int m) {
        if (m == 0 || n == 0) {
            return 0;
        } else if (P[n - 1] == Q[m - 1]) {
            return 1 + recurseLCS(P, Q, n - 1, m - 1);
        } else {
            return Math.max(recurseLCS(P, Q, n - 1, m), recurseLCS(P, Q, n, m - 1));
        }
    }

    private static int dpLCS(char[] P, char[] Q, int n, int m) {
        int result;

        if (arr[n][m] != -1)
            return arr[n][m];
        if (m == 0 || n == 0) {
            result = 0;
        } else if (P[n - 1] == Q[m - 1]) {
            result = 1 + dpLCS(P, Q, n - 1, m - 1);
        } else {
            result = Math.max(dpLCS(P, Q, n - 1, m), dpLCS(P, Q, n, m - 1));
        }

        arr[n][m] = result;

        return result;
    }
}
