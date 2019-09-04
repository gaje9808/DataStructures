package com.self.miscellaneous;

import com.self.basic.BinaryTree;
import com.self.basic.HeightOfBinaryTree;
import com.self.basic.Node;

public class HeightBalancedBT {

    public static HeightOfBinaryTree ht = new HeightOfBinaryTree();

    public static boolean isHeightBalanced(Node node) {
        if (node == null) return true;
        int lheight = ht.getHeight(node.left);
        int rheight = ht.getHeight(node.right);

        return (Math.abs(lheight-rheight)<1 && isHeightBalanced(node.left) && isHeightBalanced(node.right));
    }

    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(8);

        if (isHeightBalanced(tree.root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}
