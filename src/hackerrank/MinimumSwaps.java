package hackerrank;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MinimumSwaps {

    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{0, 0, 1, 0, 0, 1, 0}));
    }

    static int minimumSwaps(int[] arr) {
        ArrayList<Pair<Integer, Integer>> correctOrder = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            correctOrder.add(new Pair<>(arr[i], i));
        }

        correctOrder.sort(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if (o1.getKey() > o2.getKey())
                    return -1;

                else if (o1.getKey().equals(o2.getKey()))
                    return 0;

                else
                    return 1;
            }
        });

        Boolean[] vis = new Boolean[arr.length];
        Arrays.fill(vis, false);

        int result = 0;

        for (int i=0;i<arr.length;i++) {
            if (vis[i] || correctOrder.get(i).getValue() == i)
                continue;

            int cycles = 0;
            int j = i;

            while (!vis[j]) {
                vis[j] = true;

                j = correctOrder.get(j).getValue();
                cycles++;
            }

            if(cycles > 0)
            {
                result += (cycles - 1);
            }
        }

        return result;
    }
}
