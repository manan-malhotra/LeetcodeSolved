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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<Integer>();
        return inorderTraversal(root,order);
    }
    private List<Integer> inorderTraversal(TreeNode root, List<Integer> order) {
        if(root==null) return order;
        inorderTraversal(root.left,order);
        order.add(root.val);
        inorderTraversal(root.right,order);
        return order;
    }
}