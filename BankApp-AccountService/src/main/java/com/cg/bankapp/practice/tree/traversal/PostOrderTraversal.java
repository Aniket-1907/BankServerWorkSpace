package com.cg.bankapp.practice.tree.traversal;

import com.cg.bankapp.practice.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal implements Traversal<List<Integer>>{
    @Override
    public void printOrder(TreeNode root) {

        if(root == null ) return;
        printOrder(root.left);
        printOrder(root.right);
        System.out.print(root.val +"->");
    }

    @Override
    public List<Integer> getOrder(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        postOrder(root,list);
        return list;
    }

    private static void postOrder(TreeNode root, List<Integer> list){
        if(root == null ) return ;
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.val);
    }
}
