package com.cg.bankapp.practice.tree.traversal;

import com.cg.bankapp.practice.tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal implements Traversal<List<Integer>>{
    @Override
    public void printOrder(BinaryTree root) {

        if(root == null ) return;
        printOrder(root.left);
        printOrder(root.right);
        System.out.print(root.value +"->");
    }

    @Override
    public List<Integer> getOrder(BinaryTree root) {
        List<Integer> list=new ArrayList<>();
        postOrder(root,list);
        return list;
    }

    private static void postOrder(BinaryTree root, List<Integer> list){
        if(root == null ) return ;
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.value);
    }
}
