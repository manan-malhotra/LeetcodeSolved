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
    int total = 0;
    public TreeNode bstToGst(TreeNode root) {
        total = sum(root);
        inorder(root);
        return root;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        int temp = root.val;
        root.val = total;
        total = total - temp;
        inorder(root.right);
    }
    public int sum(TreeNode root){
        if(root==null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
}