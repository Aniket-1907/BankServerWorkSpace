package com.cg.bankapp.practice.tree.traversal;

import com.cg.bankapp.practice.tree.BinaryTree;

public interface Traversal<T> {
    void printOrder(BinaryTree binaryTree);
    T getOrder(BinaryTree binaryTree);
}
