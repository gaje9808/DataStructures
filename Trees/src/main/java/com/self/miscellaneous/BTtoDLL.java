package com.self.miscellaneous;

import com.self.basic.BinaryTree;
import com.self.basic.Node;


// To do
// get rid of global Variables
public class BTtoDLL {

    public static Node head = null ;

    public static Node prev = null;

    public static Node root = null;

    public static void binaryTreeToDoublyLinkedList(Node root) {
        if (root == null) return;
        binaryTreeToDoublyLinkedList(root.left);
        if (prev == null) head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        binaryTreeToDoublyLinkedList(root.right);
    }

    public static void main(String[] args)
    {
        // Let us create the tree as shown in above diagram
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        root = tree.root;

        // convert to DLL
        binaryTreeToDoublyLinkedList(root);

        // Print the converted List
        printList(head);

    }

    public static void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }
}
