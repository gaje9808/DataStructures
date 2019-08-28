package com.self.basic;

public class HeightOfBinaryTree {
    public static int getHeight(Node n) {
        if (n == null) return 0;
        return 1+ Math.max(getHeight(n.left), getHeight(n.right));
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Height of tree is : " +
                getHeight(tree.root));
    }
}
