package com.self.miscellaneous;

import com.self.basic.BinaryTree;
import com.self.basic.Node;

public class IsIdentical {
    public static boolean isidential(Node n1,Node n2) {
        if (n1 == null  && n2 == null) return true;
        if (n1 != null &&  n2 != null) {
            return ( (n1.data == n2.data) && isidential(n1.left, n2.left) && isidential(n1.right, n2.right));
        }
        return false;
    }

    public static void main(String[] args)
    {
        BinaryTree tree1 = new BinaryTree();

        tree1.root = new Node(1);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);
        tree1.root.left.left = new Node(4);
        tree1.root.left.right = new Node(5);

        BinaryTree tree2 = new BinaryTree();
        tree2.root = new Node(1);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(3);
        tree2.root.left.left = new Node(4);
        tree2.root.left.right = new Node(5);

        if (isidential(tree1.root, tree2.root))
            System.out.println("Both trees are identical");
        else
            System.out.println("Trees are not identical");

    }
}
