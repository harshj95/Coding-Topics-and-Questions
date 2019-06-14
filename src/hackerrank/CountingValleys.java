package hackerrank;

public class CountingValleys {

    public static void main(String[] args) {
        System.out.println(countingValleys(0, "DDUUUUDD"));
    }

    static int countingValleys(int n, String s) {

        int seaLevel = 0;
        int valleyCount = 0;
        for (char step : s.toCharArray()) {
            if (step == 'D') {
                --seaLevel;
            }
            if (step == 'U') {
                ++seaLevel;
            }

            if (seaLevel == 0 && step == 'U') {
                ++valleyCount;
            }
        }

        return valleyCount;
    }
}
