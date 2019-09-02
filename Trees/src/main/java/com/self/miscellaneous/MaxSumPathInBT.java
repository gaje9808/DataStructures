package com.self.miscellaneous;

import com.self.basic.BinaryTree;
import com.self.basic.Node;

public class MaxSumPathInBT {
    public static class Res{
        public int val;
    }

    public static int maxSumPathUtil(Node node, Res res) {
        if (node == null) return 0;
        int l = maxSumPathUtil(node.left,res);
        int r = maxSumPathUtil(node.right,res);
        int maxSingle = Math.max(Math.max(l,r) + node.data, node.data);
        int maxTop = Math.max(maxSingle, l+r+node.data);
        res.val =  Math.max(res.val,maxTop);
        return maxSingle;
    }

    public static int maxSumPath(Node node) {
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
        maxSumPathUtil(node,res);
        return res.val;
    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);
        System.out.println("maximum path sum is : " +
                maxSumPath(tree.root));
    }
}
