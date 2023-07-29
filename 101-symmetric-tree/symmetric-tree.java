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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        TreeNode p = root.left;
        TreeNode q = root.right;
        return same(p,q);
    }
    private boolean same(TreeNode p, TreeNode q){
        if(q==null && p==null) return true;
        if(p==null || q==null) return false;
        return p.val==q.val && same(p.left,q.right) && same(p.right,q.left);
    }
}