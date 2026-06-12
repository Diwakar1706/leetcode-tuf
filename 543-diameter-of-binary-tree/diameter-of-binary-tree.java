/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int diaofroot=solve(root.left)+solve(root.right);
        int leftdia=diameterOfBinaryTree(root.left);
        int rightdia=diameterOfBinaryTree(root.right);
        return Math.max(diaofroot,Math.max(leftdia,rightdia));
        
    }
    public int solve(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(solve(root.left),solve(root.right));
        
    }
}