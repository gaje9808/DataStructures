package com.self.viewproblems;

import com.self.basic.Node;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class PrintInVerticalOrder {
    public static void printVerticalOrder(Node n) {
        Map<Integer, Vector<Integer>> mp = new TreeMap<>();
        int hd = 0;
        getVerticalOrder(n,hd,mp);
        for (Map.Entry<Integer, Vector<Integer>> entry: mp.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    public static void getVerticalOrder(Node n, int hd, Map<Integer,Vector<Integer>> mp) {
        if (n == null) return;
        Vector<Integer> a = mp.get(hd);
        if (a == null) {
            a =  new Vector<>();
        }
        a.add(n.data);
        mp.put(hd,a);
        getVerticalOrder(n.left,hd-1,mp);
        getVerticalOrder(n.right,hd+1,mp);
    }

    public static void main(String[] args) {

        // TO DO Auto-generated method stub
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root);
    }
}
