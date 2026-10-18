package com.cg.bankapp.practice.tree;

public class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    public BinaryTree(int value, BinaryTree left, BinaryTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    public static BinaryTree createBinaryTree() {
        BinaryTree node10= new BinaryTree(10,new BinaryTree(11),null);
        BinaryTree node7 = new BinaryTree(7,new BinaryTree(9),node10);
        BinaryTree node5 = new BinaryTree(5,new BinaryTree(8),null);
        BinaryTree node3 = new BinaryTree(3,new BinaryTree(6),node7);
        BinaryTree node2 = new BinaryTree(2,new BinaryTree(4),node5);
        return new BinaryTree(1,node2,node3);
    }
}
