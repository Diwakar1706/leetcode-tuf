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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList();
        path(root,"",ans);     
        return ans;                                           
        
    }
    void path(TreeNode root,String s,List<String>list){
        if(root==null) return;
        if(root.left==null && root.right==null){
            list.add(s+root.val);
            return;
        }
        path(root.left,s+root.val+"->",list);
        path(root.right,s+root.val+"->",list);

    }
}