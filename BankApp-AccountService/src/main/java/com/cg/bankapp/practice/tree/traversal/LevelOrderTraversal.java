package com.cg.bankapp.practice.tree.traversal;

import com.cg.bankapp.practice.tree.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal implements Traversal<List<List<Integer>>>{
    @Override
    public void printOrder(BinaryTree root) {
        Queue<BinaryTree> queue=new ArrayDeque<>() ;
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTree b=queue.poll();
            if(b.left!=null) queue.add(b.left);
            if(b.right!=null) queue.add(b.right);
            System.out.print(b.value +"->");
        }
    }

    @Override
    public List<List<Integer>> getOrder(BinaryTree root) {
        List<List<Integer>> list=new ArrayList<>();
        Queue<BinaryTree> queue=new ArrayDeque<>() ;
        if(root==null) return null;
        queue.add(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer> l=new ArrayList<>();
            while(n-->0){
                if(queue.peek().left!=null) queue.add(queue.peek().left);
                if(queue.peek().right!=null) queue.add(queue.peek().right);
                l.add(queue.poll().value);
            }
            list.add(l);
        }
        return list;
    }
}
