package com.self.miscellaneous;

import com.self.basic.BinaryTree;
import com.self.basic.Node;

public class IsSymmetric {
    public static boolean isSymmetric(Node n1, Node n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 != null && n2 != null) {
            return n1.data == n2.data && isSymmetric(n1.left, n2.right) && isSymmetric(n1.right,n2.left);
        }
        return false;
    }

    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);
        boolean output = isSymmetric(tree.root, tree.root);
        if (output == true)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
