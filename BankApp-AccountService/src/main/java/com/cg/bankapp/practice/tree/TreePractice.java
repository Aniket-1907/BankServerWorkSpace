package com.cg.bankapp.practice.tree;

import com.cg.bankapp.practice.tree.traversal.*;

import java.util.*;

public class TreePractice {
    public static void main(String[] args) {

        BinaryTree root = BinaryTree.createBinaryTree();

        Traversal<List<Integer>> in=new InOrderTraversal();
        Traversal<List<Integer>> pre= new PreOrderTraversal();
        Traversal<List<Integer>> post= new PostOrderTraversal();
        Traversal<List<List<Integer>>> level= new LevelOrderTraversal();


        System.out.println( "In Order Traversal -> \n"+ in.getOrder(root));
        in.printOrder(root);
        System.out.println();

        System.out.println( "Pre Order Traversal -> \n"+ pre.getOrder(root));
        pre.printOrder(root);
        System.out.println();


        System.out.println( "Post Order Traversal -> \n"+ post.getOrder(root));
        post.printOrder(root);
        System.out.println();

        System.out.println( "Level Order Traversal -> \n"+level.getOrder(root));
        level.printOrder(root);
        System.out.println();





    }


}


