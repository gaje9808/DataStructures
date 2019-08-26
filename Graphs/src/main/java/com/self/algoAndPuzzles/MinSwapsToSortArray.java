package com.self.algoAndPuzzles;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// The problem here is to find the minimum number of swaps that'll be needed to sort an array of integers.

public class MinSwapsToSortArray {

    public static void findMinswaps(int[] a) {
        ArrayList<Pair<Integer, Integer>> arr = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            arr.add(new Pair<>(a[i], i));
        }

        arr.sort(new Comparator<Pair<Integer, Integer>>() {
            public int compare(Pair<Integer, Integer> o1,
                               Pair<Integer, Integer> o2) {
//                if (o1.getKey() < o2.getKey()) return -1;
////                else if (o1.getKey().equals(o2.getKey())) return 0;
////                else return 1;
                return o1.getKey() - o2.getKey();
            }
        });

        boolean[] visited = new boolean[a.length];
        Arrays.fill(visited, false);
        int ans = 0;

        for (Pair<Integer, Integer> p : arr) {
            System.out.println(p.getKey() + " = " + p.getValue());
        }

        for (int i = 0; i < a.length; i++) {
            if (visited[i] || arr.get(i).getValue() == i)
                continue;
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = arr.get(j).getValue();
                cycleSize++;
            }
            if (cycleSize > 0) {
                ans += (cycleSize - 1);
            }
        }
        System.out.println("Total swaps needed = " + ans);
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 4, 3, 2};
        findMinswaps(a);
    }
}
