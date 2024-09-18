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
    public int deepestLeavesSum(TreeNode root) {
        int maxH = height(root);
        int sum = findSum(root,maxH-1);
        return sum;
    }
    public int findSum(TreeNode root, int h){
        if(root==null) return 0;
        if(h==0) return root.val;
        else{
            return findSum(root.left,h-1) + findSum(root.right,h-1);
        }
    }
    public int height(TreeNode root){
        if(root==null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
}