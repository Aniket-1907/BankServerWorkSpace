package com.cg.bankapp.practice.tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static TreeNode createBinaryTree() {
        TreeNode node10= new TreeNode(10,new TreeNode(11),null);
        TreeNode node7 = new TreeNode(7,new TreeNode(9),node10);
        TreeNode node5 = new TreeNode(5,new TreeNode(8),null);
        TreeNode node3 = new TreeNode(3,new TreeNode(6),node7);
        TreeNode node2 = new TreeNode(2,new TreeNode(4),node5);
        return new TreeNode(1,node2,node3);

/*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
               /     / \
              8     9  10
                       /
                      11
*/
    }

    public static TreeNode createTreeNodeForKthSmallest() {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(1);
        return root;
/*
                      5
                    /   \
                   3     6
                  / \
                 2   4
                /
               1
*/
    }
}
