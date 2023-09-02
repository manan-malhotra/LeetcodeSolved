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
    public void flatten(TreeNode root) {
        if(root==null) return;
        if(root.left!=null){
        TreeNode rightMost = findRightmost(root);
        // System.out.println(rightMost.val+" "+root.right.val);
        rightMost.right = root.right;
        root.right=root.left;
        root.left = null;
        }
        flatten(root.right);
    }
    public TreeNode findRightmost(TreeNode root){
        if(root.left==null) return root;
        TreeNode curr = root.left;
        while(curr.right!=null) curr=curr.right;
        // System.out.println(curr.val);
        return curr;
    }
    
}