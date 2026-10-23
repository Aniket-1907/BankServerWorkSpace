package com.cg.bankapp.practice.tree.traversal;

import com.cg.bankapp.practice.tree.TreeNode;

import java.util.List;

public class VerticalOrderTraversal implements Traversal<List<List<Integer>>>{

    @Override
    public void printOrder(TreeNode root) {

    }

    @Override
    public List<List<Integer>> getOrder(TreeNode root) {
//        traverse(Character.v)
        try{
            int i=0;
            i++;
            System.out.println(i);
        }
        catch (Throwable throwable){
            System.out.println("Caught Throwable");
        }

        return null;
    }
    private int[] traverse(TreeNode root,List<int[]> res,int[] prev){
        if(root == null) return null;
        return null;
    }
}
