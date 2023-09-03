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
        findMax(root);
        return maxi;
        
    }
    public int findMax(TreeNode root){
        if(root == null) return 0;
        int leftMax = Math.max(0,findMax(root.left));
        int rightMax = Math.max(0,findMax(root.right));
        int sum = leftMax+rightMax+root.val;
        maxi = Math.max(maxi,sum);
        return Math.max(leftMax,rightMax) + root.val;
    }
}