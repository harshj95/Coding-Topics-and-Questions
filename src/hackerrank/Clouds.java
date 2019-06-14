package hackerrank;

public class Clouds {

    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0}));
    }

    static int jumpingOnClouds(int[] c) {
        int steps = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i + 2] == 0) {
                if (i + 2 == c.length - 1) return ++steps;
                steps++;
                i += 1;
            } else if (c[i + 1] == 0) {
                steps++;
            }
        }

        return steps;
    }
}
