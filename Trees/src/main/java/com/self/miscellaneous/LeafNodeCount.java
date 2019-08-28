package com.self.miscellaneous;

import com.self.basic.BinaryTree;
import com.self.basic.Node;

public class LeafNodeCount {
    public static int getCount(Node n) {
        if (n == null) return 0;
        if (n.left == null && n.right == null) return 1;
        return getCount(n.left) + getCount(n.right);
    }

    public static void main(String args[])
    {
        /* create a tree */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        /* get leaf count of the abve tree */
        System.out.println("The leaf count of binary tree is : "
                + getCount(tree.root));
    }
}
