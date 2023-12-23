package coreJava;

import java.util.HashMap;
import java.util.Map;

public class PairSumEqualToK {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 1};
        int k = 6;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int sno = k - arr[i];
            if (map.containsKey(sno)) {
                count++;
            }
            map.put(arr[i], 1);
        }

        System.out.println(count);
    }
}
