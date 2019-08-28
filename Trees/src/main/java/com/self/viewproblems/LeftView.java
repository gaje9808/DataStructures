package com.self.viewproblems;

import com.self.basic.BinaryTree;
import com.self.basic.Node;

public class LeftView {
    public static void printLeftView(Node n, int level, int[] maxlevel) {
        if (n == null) return;
        if (level > maxlevel[0]) {
            maxlevel[0] = level;
            System.out.println(n.data);
        }

        printLeftView(n.left,level+1,maxlevel);
        printLeftView(n.right,level+1,maxlevel);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);
        int[] maxlevel = new int[]{0};

        printLeftView(tree.root,1,maxlevel);
    }
}
