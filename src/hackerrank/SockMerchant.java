package hackerrank;

import java.util.HashMap;

public class SockMerchant {

    public static void main(String[] args) {

    }

    public int sockMerchant(int n, int[] ar) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(ar[i])) {
                map.put(ar[i], map.get(ar[i]) + 1);
            } else {
                map.put(ar[i], 1);
            }
        }

        int pairs = 0;

        for (int key : map.keySet()) {
            pairs += map.get(key) / 2;
        }

        return pairs;
    }
}
