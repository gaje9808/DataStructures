package com.self.miscellaneous;

import com.self.basic.BinaryTree;
import com.self.basic.HeightOfBinaryTree;
import com.self.basic.Node;

public class DiameterOfBT {
    public static HeightOfBinaryTree h = new HeightOfBinaryTree();

    public static int getDiameter(Node node) {
        if (node == null) return 0;
        int lheight = h.getHeight(node.left);
        int rheight = h.getHeight(node.right);
        int ldiameter = getDiameter(node.left);
        int rdiameter = getDiameter(node.right);

        return Math.max(Math.max(ldiameter,rdiameter),lheight+rheight+1);
    }

    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("The diameter of given binary tree is : "
                + getDiameter(tree.root));
    }
}
