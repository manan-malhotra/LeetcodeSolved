/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(p.val>root.val && q.val>root.val) return helper(root.right,p,q);
        if(p.val<root.val && q.val<root.val) return helper(root.left,p,q);
        if(p.val==root.val || q.val==root.val) return root;

        TreeNode leftAns = helper(root.left,p,q);
        TreeNode rightAns = helper(root.right,p,q);

        if(leftAns==null) return rightAns;
        if(rightAns==null) return leftAns;
        return root;

    }
}