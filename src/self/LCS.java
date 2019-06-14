package self;

public class LCS {

    private static String vowels = "aeiou";

    private static String first = "aeiou";
    private static String second = "aaeeaeeeiou";
    private static String third = "aei";
    private static String four = "aaeeou";
    private static String five = "aaieou";
    private static String six = "aeiou";
    private static String seven = "aeiou";
    private static String eight = "aeiou";

    private static int[][] arr = new int[first.length() + 1][second.length() + 1];

    public static void main(String[] args) {
//        for (int i = 0; i < first.length() + 1; i++) {
//            for (int j = 0; j < second.length() + 1; j++) {
//                arr[i][j] = -1;
//            }
//        }

        System.out.println(recurseLCSVowel(first.toCharArray(), vowels.toCharArray(), first.length(), vowels.length()));
//        System.out.println(recurseLCSVowel(second.toCharArray(), vowels.toCharArray(), second.length(), vowels.length()));
//        System.out.println(recurseLCSVowel(third.toCharArray(), vowels.toCharArray(), third.length(), vowels.length()));
//        System.out.println(recurseLCSVowel(four.toCharArray(), vowels.toCharArray(), four.length(), vowels.length()));
//        System.out.println(recurseLCSVowel(five.toCharArray(), vowels.toCharArray(), five.length(), vowels.length()));
    }

    private static int recurseLCS(char[] P, char[] Q, int n, int m) {
        if (m == 0 || n == 0) {
            return 0;
        } else if (P[n - 1] == Q[m - 1]) {
            return 1 + recurseLCS(P, Q, n - 1, m);
        } else {
            return Math.max(recurseLCS(P, Q, n - 1, m), recurseLCS(P, Q, n, m - 1));
        }
    }

    private static int recurseLCSVowel(char[] P, char[] Q, int n, int m) {
        if (n == 0 && m > 0) {
            return -2000;
        } else if (P[n - 1] == Q[m - 1]) {
            return 1 + recurseLCSVowel(P, Q, n - 1, m);
        } else {
            if (m == 1) {
                return recurseLCSVowel(P, Q, n - 1, m);
            }
            if (P[n - 1] == Q[m - 2]) {
                return recurseLCSVowel(P, Q, n, m - 1);
            } else {
                return recurseLCSVowel(P, Q, n - 1, m);
            }
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
