package com.cg.bankapp.practice.tree;

import com.cg.bankapp.practice.tree.traversal.*;

import java.util.*;

public class TreePractice {
    public static void main(String[] args) {

        TreeNode root = TreeNode.createBinaryTree();

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


        level.printOrder(sortedArrayToBST(new int[]{-10,-3,0,5,9}));
        System.out.println();

        TreeNode root2=TreeNode.createTreeNodeForKthSmallest();
        System.out.println("Kth smallest - "+kthSmallest(root2,3));

    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    public static int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        findKthSmallest(root.left,k,pq);
        if(pq.size()==k) return pq.peek();
        findKthSmallest(root.right,k,pq);
        return pq.peek();
    }
    private static void findKthSmallest(TreeNode root, int k,PriorityQueue<Integer> pq) {
        if(root == null ) return;
        if(!pq.isEmpty()){
            if(pq.size()==k){
                if(pq.peek()>root.val){
                    pq.poll();
                }
            }
            // pq.add(root.val);
        }
        pq.add(root.val);

        findKthSmallest(root.left,k,pq);
        findKthSmallest(root.right,k,pq);
    }
}


