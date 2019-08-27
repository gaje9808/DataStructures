package com.self.algoAndPuzzles;

import com.self.basics.Graph;
import com.self.basics.TopologicalSort;

public class AlienDictionary {
    public static void printOrder(String[] s, int n) {
        Graph g = new Graph(n);
        for (int i=0;i<n-1;i++) {
            String word1 = s[i];
            String word2 = s[i+1];
            for (int j=0;j<Math.min(word1.length(), word2.length());j++){
                if (word1.charAt(j) != word2.charAt(j)) {
                    g.addEdge(word1.charAt(j) -'a', word2.charAt(j) - 'a');
                    break;
                }
            }
        }
        TopologicalSort t = new TopologicalSort();
        t.dfs(g);
    }

    public static void main(String[] args)
    {
        String[] words = {"caa", "aaa", "aab"};
        printOrder(words, 3);
    }
}
