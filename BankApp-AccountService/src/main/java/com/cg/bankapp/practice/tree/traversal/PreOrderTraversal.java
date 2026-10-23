package com.cg.bankapp.practice.tree.traversal;

import com.cg.bankapp.practice.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal implements Traversal<List<Integer>>{
    @Override
    public void printOrder(TreeNode root) {
        if(root == null ) return;
        printOrder(root.left);
        System.out.print(root.val +"->");
        printOrder(root.right);
    }

    @Override
    public List<Integer> getOrder(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        preOrder(root,list);
        return list;
    }
    private static void preOrder(TreeNode root, List<Integer> list){
        if(root == null ) return ;
        list.add(root.val);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }
}
