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
    public List<Integer> preorderTraversal(TreeNode root) {
        // N L R
        List<Integer> order = new ArrayList<Integer>();
        return preorderTraversal(root,order);
    }
    public List<Integer> preorderTraversal(TreeNode root, List<Integer> order) {
        if(root==null) return order;
        order.add(root.val);
        preorderTraversal(root.left,order);
        preorderTraversal(root.right,order);
        return order;
    }
}