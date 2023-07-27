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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<Integer>();
        return postorderTraversal(root,order);
    }
    private List<Integer> postorderTraversal(TreeNode root, List<Integer> order) {
        if(root==null) return order;
        postorderTraversal(root.left,order);
        postorderTraversal(root.right,order);
        order.add(root.val);
        return order;
    }
}