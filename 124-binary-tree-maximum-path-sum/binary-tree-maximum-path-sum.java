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
    int maxi = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxi;
    }
    public int maxPath(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = Math.max(maxPath(root.left),0);
        int right = Math.max(maxPath(root.right),0);
        maxi = Math.max(left+right+root.val,maxi);
        return Math.max(left,right) + root.val;
        
    }
}
