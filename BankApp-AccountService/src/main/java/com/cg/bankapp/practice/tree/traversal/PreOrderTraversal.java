package com.cg.bankapp.practice.tree.traversal;

import com.cg.bankapp.practice.tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal implements Traversal<List<Integer>>{
    @Override
    public void printOrder(BinaryTree root) {
        if(root == null ) return;
        printOrder(root.left);
        System.out.print(root.value +"->");
        printOrder(root.right);
    }

    @Override
    public List<Integer> getOrder(BinaryTree root) {
        List<Integer> list=new ArrayList<>();
        preOrder(root,list);
        return list;
    }
    private static void preOrder(BinaryTree root, List<Integer> list){
        if(root == null ) return ;
        list.add(root.value);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }
}
