package com.self.viewproblems;

import com.self.basic.Node;

import java.util.*;

public class BottomView {
    public static void bottomView(Node n,int hd) {
        if (n== null) return;
        Map<Integer, ArrayList<Integer>> mp = new TreeMap<>();
        Queue<modifiedNode> queue = new LinkedList<>();

        queue.add(new modifiedNode(n,hd));

        while (!queue.isEmpty()) {
            modifiedNode node = queue.remove();
            ArrayList<Integer> a = mp.get(node.hd);
            if (a == null) {
                a = new ArrayList<>();
            }
            a.add(node.n.data);
            mp.put(node.hd, a);

            if (node.n.left != null) {
                queue.add(new modifiedNode(node.n.left,node.hd-1));
            }
            if (node.n.right != null) {
                queue.add(new modifiedNode(node.n.right,node.hd+1));
            }

        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry : mp.entrySet()) {
            System.out.println(entry.getValue().get(entry.getValue().size()-1));
        }
    }

    public static class modifiedNode {
        Node n;
        int hd;

        public modifiedNode(Node root, int hd) {
            n = root;
            this.hd = hd;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        System.out.println("Bottom view of the given binary tree:");
        bottomView(root,0);
    }
}
