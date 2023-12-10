package coreJava;

import java.util.ArrayList;
import java.util.List;

public class MergeListSorted {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(3, 5, 6));
        list.add(List.of(2, 4, 5, 5));

        List<Integer> merged = mergeList(list);

        // Sort the merged list without using Collections.sort
        bubbleSort(merged);

        // Print the sorted merged list
        System.out.println(merged);
    }

    public static List<Integer> mergeList(List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                // Compare individual elements within the lists
                if (list.get(j).get(0) > list.get(j + 1).get(0)) {
                    // Swap the entire lists
                    List<Integer> temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }

        // Flatten the nested lists into a single list
        List<Integer> merged = new ArrayList<>();
        for (List<Integer> sublist : list) {
            merged.addAll(sublist);
        }

        return merged;
    }

    // Bubble sort implementation for sorting the merged list
    private static void bubbleSort(List<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    // Swap elements
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}
