package com.cg.bankapp.practice.tree.traversal;

import com.cg.bankapp.practice.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal implements Traversal<List<Integer>>{
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
        inOrder(root,list);
        return list;
    }
    private static void inOrder(TreeNode root, List<Integer> list){
        if(root == null ) return ;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}
