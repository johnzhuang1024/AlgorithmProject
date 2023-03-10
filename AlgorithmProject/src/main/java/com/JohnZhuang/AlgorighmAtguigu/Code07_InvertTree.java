package com.JohnZhuang.AlgorighmAtguigu;

/**
 * @author JohnZhuang
 * @version 1.0
 * @description: TODO
 * @date 2023/3/10 10:12
 */
public class Code07_InvertTree {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 用时：0ms
    // 内存：38.9M
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode result = new TreeNode(root.val, invertTree(root.right), invertTree(root.left));

        return result;
    }

    // 用时：0ms
    // 内存：39M
    public TreeNode invertTree_Ans(TreeNode root) {
        if (root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree_Ans(root.left);
            invertTree_Ans(root.right);
        }
        return root;
    }
}
