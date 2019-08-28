package com.self.bSTProblems;

import com.self.basic.BinaryTree;
import com.self.basic.Node;

public class CheckForBST {
    public static boolean isBST (Node n, int min, int max) {
        if (n == null) return true;
        if ( n.data > max || n.data < min ) return false;
        return isBST(n.left,min, n.data-1) && isBST(n.right,n.data+1,max);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        System.out.println(isBST(tree.root,Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
