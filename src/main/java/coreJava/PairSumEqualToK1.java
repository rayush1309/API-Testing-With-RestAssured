package coreJava;

import java.util.HashMap;
import java.util.Map;
    public class PairSumEqualToK1 {
        public static void main(String[] args) {
            int[] arr = {1, 5, 7, 1};
            int k = 6;
            int count = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                int sno = k - arr[i];
                if (map.containsKey(sno)) {
                    System.out.println(arr[i]+" "+ sno);
                    count+=map.get(sno);
                }
                map.put(arr[i], 1);

            }

            System.out.println(count);
        }
    }

    /*
Time Complexity:
The outer loop runs for each element in the array, iterating through all n elements (where n is the length of the array).
The inner operations inside the loop, such as map.containsKey() and map.put(), take constant time on average,
assuming that the hashing function of the HashMap is efficient.
Therefore, the overall time complexity is O(n).

Space Complexity:
The space used by the HashMap is proportional to the number of unique elements encountered in the array.
In the worst case, where all elements are unique, the space complexity would be O(n).
The additional space used for variables (int k, int count, int sno, and the loop index i) is constant.
Therefor e, the overall space complexity is O(n) due to the HashMap.

In summary, the code has a time complexity of O(n) and a space complexity of O(n).

 */