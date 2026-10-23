package com.cg.bankapp.practice.tree.traversal;

import com.cg.bankapp.practice.tree.TreeNode;

public interface Traversal<T> {
    void printOrder(TreeNode treeNode);
    T getOrder(TreeNode treeNode);
}
